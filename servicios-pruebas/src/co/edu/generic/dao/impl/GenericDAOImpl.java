/**
 * 
 */
package co.edu.generic.dao.impl;

/**
 * @author john
 *
 */

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import co.edu.generic.dao.GenericDAO;

/**
 * Represents the Data Access Object class, and defines the generic interaction
 * between the system and the database.
 * 
 * @author John
 */
@Transactional
public class GenericDAOImpl<T, Key extends Serializable> implements
		GenericDAO<T, Key> {

	// @Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	protected Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}

	/**
	 * {@inheritDoc}
	 */
	protected void handleException(Exception e) throws Exception {
		throw new Exception(e);
	}

	/**
	 * {@inheritDoc}
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public void delete(T obj) throws Exception {
		try {
			this.getSession().delete(obj);
		} catch (Exception ex) {
			handleException(ex);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public T find(Class<T> clazz, Key id) throws Exception {
		T resultado = null;
		try {
			resultado = ((T) this.getSession().get(clazz, id));
		} catch (Exception ex) {
			handleException(ex);
		}
		return resultado;
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<T> findAll(Class<T> clazz) throws Exception {
		List<T> resultados = null;
		try {
			resultados = this.getSession().createCriteria(clazz).list();
		} catch (Exception ex) {
			handleException(ex);
		}
		return resultados;
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<T> findAllByExample(T ejemplo) throws Exception {
		List<T> resultados = null;
		try {
			Criteria criteria = this.getSession().createCriteria(
					ejemplo.getClass());
			criteria.add(Example.create(ejemplo));
			resultados = criteria.list();
		} catch (Exception ex) {
			handleException(ex);
		}
		return resultados;
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public T findByExample(T ejemplo) throws Exception {
		T result = null;
		try {
			Criteria criteria = this.getSession().createCriteria(
					ejemplo.getClass());
			criteria.add(Example.create(ejemplo));
			criteria.setMaxResults(1);
			result = (T) criteria.uniqueResult();
		} catch (Exception ex) {
			handleException(ex);
		}
		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public T save(T obj) throws Exception {
		try {
			getSession().save(obj);
		} catch (Exception ex) {
			handleException(ex);
		}
		return obj;
	}

	/**
	 * {@inheritDoc}
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public void update(T obj) throws Exception {
		try {
			getSession().update(obj);
		} catch (Exception ex) {
			handleException(ex);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public Integer saveOrUpdateSql(Class<T> clazz, final String sql)
			throws Exception {
		Session session = null;
		try {
			session = this.getSession().getSessionFactory().openSession();
			Query q = session.createSQLQuery(sql);
			return q.executeUpdate();
		} catch (Exception ex) {
			handleException(ex);
		} finally {
			if (session != null) {
				session.flush();
				session.close();
			}
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public Integer editHQL(Class<T> clazz, final String hql,
			Map<String, Object> params) throws Exception {
		Session session = null;
		try {
			session = this.getSession().getSessionFactory().openSession();
			Query q = session.createQuery(hql);
			Iterator<Entry<String, Object>> itParams = params.entrySet()
					.iterator();
			while (itParams.hasNext()) {
				Map.Entry<String, Object> e = (Map.Entry<String, Object>) itParams
						.next();
				q.setParameter(e.getKey(), e.getValue());
			}
			return q.executeUpdate();
		} catch (Exception ex) {
			handleException(ex);
		} finally {
			if (session != null)
				session.flush();
			session.close();
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	@SuppressWarnings("unchecked")
	public List<T> findAll(Class<T> clazz, String filter) throws Exception {
		try {
			StringBuilder sb = new StringBuilder("from ").append(clazz
					.getSimpleName());
			if (!StringUtils.isEmpty(filter)) {
				sb.append(" where ").append(filter);
			}
			return this.getSession().createCriteria(sb.toString()).list();
		} catch (Exception ex) {
			handleException(ex);
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	@SuppressWarnings("unchecked")
	public List<T> findAllSql(final Class<T> clazz, final String sql)
			throws Exception {
		try {
			Query query = this.getSession().createSQLQuery(sql)
					.addEntity(clazz);
			return query.list();
		} catch (Exception ex) {
			handleException(ex);
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	@Override
	public List<T> findSql(Class<T> clazz, final String sql,
			final Map<String, Object> params) throws Exception {
		try {
			Query qr = this.getSession().createSQLQuery(sql).addEntity(clazz);
			for (Entry<String, Object> parm : params.entrySet()) {
				qr.setParameter(parm.getKey(), parm.getValue());
			}
			qr.isReadOnly();
			return qr.list();
			/*
			 * return this.getSession().execute( new
			 * HibernateCallback<List<T>>() { public List<T>
			 * doInHibernate(Session ss) throws HibernateException, SQLException
			 * { Query q = (Query) ss.createSQLQuery(sql);
			 * 
			 * List<T> list = q.list(); return (List<T>) list; } });
			 */
		} catch (Exception ex) {
			handleException(ex);
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	@Override
	public List<T> findSqlBean(Class<T> clazz, final String sql,
			final Map<String, Object> params) throws Exception {
		try {
			Query qr = this.getSession().createSQLQuery(sql)
					.setResultTransformer(Transformers.aliasToBean(clazz));
			for (Entry<String, Object> parm : params.entrySet()) {
				qr.setParameter(parm.getKey(), parm.getValue());
			}
			qr.isReadOnly();
			return qr.list();
			/*
			 * return this.getSession().execute( new
			 * HibernateCallback<List<T>>() { public List<T>
			 * doInHibernate(Session ss) throws HibernateException, SQLException
			 * { Query q = (Query) ss.createSQLQuery(sql);
			 * 
			 * List<T> list = q.list(); return (List<T>) list; } });
			 */
		} catch (Exception ex) {
			handleException(ex);
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<T> findHql(Class<T> clazz, String hql) throws Exception {
		try {
			if (!StringUtils.isEmpty(hql)) {
				return this.getSession().createQuery(hql).list();
			}
		} catch (Exception ex) {
			handleException(ex);
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 */

	@SuppressWarnings("unchecked")
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<T> findHql(Class<T> clazz, String hql,
			Map<String, Object> params) throws Exception {
		try {
			if (!StringUtils.isEmpty(hql)) {
				Query q = this.getSession().createQuery(hql);
				Iterator<Entry<String, Object>> itParams = params.entrySet()
						.iterator();
				while (itParams.hasNext()) {
					Map.Entry<String, Object> e = (Map.Entry<String, Object>) itParams
							.next();
					q.setParameter(e.getKey(), e.getValue());
				}
				return q.list();
			} else {
				return this.getSession().createCriteria(clazz).list();
			}
		} catch (Exception ex) {
			handleException(ex);
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<T> findAll(Class<T> clazz, String filter, String Order)
			throws Exception {
		try {
			StringBuilder sb = new StringBuilder("from ").append(clazz
					.getSimpleName());
			if (!StringUtils.isEmpty(filter)) {
				sb.append(" where ").append(filter);
			}
			if (!StringUtils.isEmpty(Order)) {
				sb.append(" order by  ").append(Order);
			}
			return this.getSession().createQuery(sb.toString()).list();
		} catch (Exception ex) {
			handleException(ex);
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public void saveOrUpdate(T obj) throws Exception {
		try {
			getSession().saveOrUpdate(obj);
		} catch (Exception ex) {
			handleException(ex);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<T> findAll(Class<T> clazz, Map<String, Object> params)
			throws Exception {
		try {
			DetachedCriteria crit = DetachedCriteria.forClass(clazz);
			if (params != null) {
				Set<Entry<String, Object>> setParams = params.entrySet();
				Iterator<Entry<String, Object>> itParams = setParams.iterator();
				while (null != itParams && itParams.hasNext()) {
					Entry<String, Object> entry = itParams.next();
					if (String.class.isAssignableFrom(entry.getValue()
							.getClass())) {
						crit.add(Restrictions.like(entry.getKey(),
								entry.getValue()));
					} else {
						crit.add(Restrictions.eq(entry.getKey(),
								entry.getValue()));
					}
				}
			}
			Criteria criteria = crit.getExecutableCriteria(this.getSession());

			return criteria.list();
		} catch (Exception ex) {
			handleException(ex);
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<T> findAll(Class<T> clazz, Map<String, Object> params,
			String orderProperty) throws Exception {
		try {
			DetachedCriteria crit = DetachedCriteria.forClass(clazz);
			Set<Entry<String, Object>> setParams = params.entrySet();
			Iterator<Entry<String, Object>> itParams = setParams.iterator();
			while (null != itParams && itParams.hasNext()) {
				Entry<String, Object> entry = itParams.next();
				if (String.class.isAssignableFrom(entry.getValue().getClass())) {
					crit.add(Restrictions.like(entry.getKey(), entry.getValue()));
				} else {
					crit.add(Restrictions.eq(entry.getKey(), entry.getValue()));
				}
			}
			if (!StringUtils.isEmpty(orderProperty)) {
				crit.addOrder(Order.asc(orderProperty));
			}
			Criteria criteria = crit.getExecutableCriteria(this.getSession());

			return criteria.list();
		} catch (Exception ex) {
			handleException(ex);
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<T> findAll(Class<T> clazz, Map<String, Object> params,
			String orderProperty, boolean desc) throws Exception {
		try {
			DetachedCriteria crit = DetachedCriteria.forClass(clazz);
			Set<Entry<String, Object>> setParams = params.entrySet();
			Iterator<Entry<String, Object>> itParams = setParams.iterator();
			while (null != itParams && itParams.hasNext()) {
				Entry<String, Object> entry = itParams.next();
				if (String.class.isAssignableFrom(entry.getValue().getClass())) {
					crit.add(Restrictions.like(entry.getKey(), entry.getValue()));
				} else {
					crit.add(Restrictions.eq(entry.getKey(), entry.getValue()));
				}
			}
			if (!StringUtils.isEmpty(orderProperty)) {
				crit.addOrder(desc ? Order.desc(orderProperty) : Order
						.asc(orderProperty));
			}
			Criteria criteria = crit.getExecutableCriteria(this.getSession());

			return criteria.list();
		} catch (Exception ex) {
			handleException(ex);
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public void saveOrUpdateAll(List<T> listaElementos) throws Exception {
		try {
			for (T t : listaElementos) {
				this.getSession().saveOrUpdate(t);
			}
		} catch (Exception ex) {
			handleException(ex);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	@SuppressWarnings("unchecked")
	public List<T> executeNameQuery(String queryName,
			String[] nombreParametros, Object[] valoresParametros)
			throws Exception {
		try {
			Query queryObject = this.getSession().getNamedQuery(queryName);
			if (valoresParametros != null) {
				for (int i = 0; i < valoresParametros.length; i++) {
					applyNamedParameterToQuery(queryObject,
							nombreParametros[i], valoresParametros[i]);
				}
			}
			return queryObject.list();
		} catch (Exception ex) {
			handleException(ex);
		}
		return null;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	@SuppressWarnings("unchecked")
	public T merge(T obj) throws Exception {
		T resultado = null;
		try {
			resultado = ((T) this.getSession().merge(obj));
		} catch (Exception ex) {
			handleException(ex);
		}
		return resultado;
	}

	@SuppressWarnings("unchecked")
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	@Override
	public List<T> findCriteriaDinamico(DetachedCriteria detachedCriteria)
			throws Exception {

		try {
			Criteria criteria = detachedCriteria.getExecutableCriteria(this
					.getSession());

			return criteria.list();
		} catch (Exception ex) {
			ex.printStackTrace();
			handleException(ex);
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	@Override
	public List<T> findCriteriaDinamico(DetachedCriteria detachedCriteria,
			int limit) throws Exception {

		List<T> tmpLst = new ArrayList<T>();
		try {
			Criteria executableCriteria = detachedCriteria
					.getExecutableCriteria(this.getSession());
			if (limit > 0) {
				executableCriteria.setMaxResults(limit);
			}
			return executableCriteria.list();
		} catch (Exception ex) {
			ex.printStackTrace();
			handleException(ex);
		}
		return tmpLst;

		// return this.getSession().findByCriteria(detachedCriteria);
	}

	@SuppressWarnings("unchecked")
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	@Override
	public List<T> findCriteriaDinamico(DetachedCriteria detachedCriteria,
			int pageSize, int page) throws Exception {

		List<T> tmpLst = new ArrayList<T>();
		try {
			Criteria executableCriteria = detachedCriteria
					.getExecutableCriteria(this.getSession());
			if (page > 0) {
				executableCriteria.setFirstResult((page - 1) * pageSize);
			}
			if (pageSize > 0) {
				executableCriteria.setMaxResults(pageSize);
			}
			return executableCriteria.list();
		} catch (Exception ex) {
			ex.printStackTrace();
			handleException(ex);
		}
		return tmpLst;
	}

	@SuppressWarnings("unchecked")
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	@Override
	public PagingResult<T> findCriteriaDinamicoPageResult(
			DetachedCriteria detachedCriteria, int pageSize, int page)
			throws Exception {
		PagingResult<T> pagingResult = new PagingResult<T>();
		List<T> tmpLst = new ArrayList<T>();
		try {
			Criteria executableCriteria = detachedCriteria
					.getExecutableCriteria(this.getSession());
			if (page > 0) {
				executableCriteria.setFirstResult((page - 1) * pageSize);
			}
			if (pageSize > 0) {
				executableCriteria.setMaxResults(pageSize);
			}
			tmpLst = executableCriteria.list();

			detachedCriteria.setProjection(Projections.rowCount());

			executableCriteria = detachedCriteria.getExecutableCriteria(this
					.getSession());
			Long rwLst = (Long) executableCriteria.uniqueResult();

			pagingResult.setList(tmpLst);
			pagingResult.setRowsCount(rwLst);

		} catch (Exception ex) {
			ex.printStackTrace();
			handleException(ex);
		}
		return pagingResult;
	}

	/*
	 * private HibernateCallback getFindByCriteriaPaginatedCallback(final
	 * DetachedCriteria criteria, final Integer firstElement, final Integer
	 * count) { Criteria criteriaExec =
	 * criteria.getExecutableCriteria(super.getSession()); int size =
	 * criteriaExec.list().size(); List list =
	 * criteriaExec.setFirstResult(firstElement).setMaxResults(count).list();
	 * return new Hi(list, firstElement, count, size); return null; }
	 */

	/**
	 * Apply the given name parameter to the given Query object.
	 * 
	 * @param queryObject
	 *            the Query object
	 * @param paramName
	 *            the name of the parameter
	 * @param value
	 *            the value of the parameter
	 * @throws HibernateException
	 *             if thrown by the Query object
	 */
	protected void applyNamedParameterToQuery(Query queryObject,
			String paramName, Object value) throws HibernateException {

		if (value instanceof Collection) {
			queryObject.setParameterList(paramName, (Collection<?>) value);
		} else if (value instanceof Object[]) {
			queryObject.setParameterList(paramName, (Object[]) value);
		} else {
			queryObject.setParameter(paramName, value);
		}
	}
}

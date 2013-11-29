/**
 * 
 */
package co.edu.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
/**
 * @author john
 * 
 */
public class ServiceLocator implements ApplicationContextAware {
	private static ServiceLocator instance;
	private ApplicationContext ctx;

	public static ServiceLocator getInstance() {
		if (instance == null) {
			instance = new ServiceLocator();
		}
		return instance;
	}

	public void setApplicationContext(ApplicationContext c)
			throws BeansException {
		this.ctx = c;
	}

	@Deprecated
	public <T> T getServicio(Class<T> c) {
		return this.ctx.getBean(c);
	}

	public <T> T getServicio(String idBean, Class<T> c) {
		return this.ctx.getBean(idBean, c);
	}
}
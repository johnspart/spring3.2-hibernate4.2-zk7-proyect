package test;

import java.util.ArrayList;
import java.util.List;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zul.ListModel;
import org.zkoss.zul.ListModelList;

/**
 * tested with ZK 6.5.3
 * 
 * @author benbai
 * 
 */
@SuppressWarnings({ "rawtypes", "unchecked" })
public class TestVM {
	private int _active = 0;

	private int _viewSize = 100;
	private int _total = 1000000;

	// assume get data by start/end index
	public ListModel getModel() {
		List l = new ArrayList();
		int start = _active * _viewSize + 1;
		int end = Math.min((_active + 1) * _viewSize, _total);
		for (int i = start; i <= end; i++) {
			l.add("Item " + i);
			System.out.println("Item " + i);
		}
		return new ListModelList(l);
	}

	// getters, setter
	public int getTotalSize() {
		return _total;
	}

	public int getPageSize() {
		return _viewSize;
	}

	public int getActivePage() {
		return _active;
	}

	public void setActivePage(int active) {
		_active = active;
	}

	@Command
	@NotifyChange("model")
	public void refreshModel() {
		// empty function for command to trigger NotifyChange
	}
}
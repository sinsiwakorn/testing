package th.co.cdgs.bean;

public class TestBean<T, E> {
	private T arrangeValue;
	private E expectValue;
	public TestBean(T arrangeValue, E expectValue) {
		super();
		this.arrangeValue = arrangeValue;
		this.expectValue = expectValue;
	}
	public T getArrangeValue() {
		return arrangeValue;
	}
	public void setArrangeValue(T arrangeValue) {
		this.arrangeValue = arrangeValue;
	}
	public E getExpectValue() {
		return expectValue;
	}
	public void setExpectValue(E expectValue) {
		this.expectValue = expectValue;
	}
	@Override
	public String toString() {
		return "TestBean [arrangeValue=" + arrangeValue + ", expectValue=" + expectValue + "]";
	}
}

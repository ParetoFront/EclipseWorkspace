import org.apache.commons.beanutils.BeanUtils;

public class introSpect {
	public static void main(String[] args) throws Exception {
		String className = "Person";
		Class cla = Class.forName(className);
		Object bean = cla.newInstance();
		
		BeanUtils.setProperty(bean, "name", "caacs");
		BeanUtils.setProperty(bean, "age", "23");
		System.out.println(BeanUtils.getProperty(bean, "age"));
	}
}

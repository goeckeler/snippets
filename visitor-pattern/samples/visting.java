public abstract class Visitor {

	public abstract void visit(Customer customer);
	public abstract void visit(Order order);
	public abstract void visit(Item item);
	public abstract void defaultVisit(Object object);

	public void visit(Object object) {
		try
		{
			Method downPolymorphic = object.getClass().getMethod("visit",
				new Class[] { object.getClass() });

			if (downPolymorphic == null) {
				defaultVisit(object);
			} else {
				downPolymorphic.invoke(this, new Object[] {object});
			}
		}
		catch (NoSuchMethodException e)
		{
			this.defaultVisit(object);
		}
		catch (InvocationTargetException e)
		{
			this.defaultVisit(object);
		}
		catch (IllegalAccessException e)
		{
			this.defaultVisit(object);
		}
	}
}



public void defaultVisit(Object object)
{
	// if we don't know the class we do nothing
	if (object.getClass().equals(Product.class))
	{
		System.out.println("default visit: "
			+ object.getClass().getSimpleName());
		itemsNo++;
	}
}
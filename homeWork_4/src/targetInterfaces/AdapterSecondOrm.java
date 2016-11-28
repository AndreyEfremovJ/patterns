package targetInterfaces;

import secondOrmLibrary.ISecondOrm;

public abstract class AdapterSecondOrm<ISecondOrmContext> implements ITarget{
	
	ISecondOrm secondOrm;
	
	public  ISecondOrmContext getContextSecondOrm() {
		return (ISecondOrmContext) secondOrm.getContext();
	}
}

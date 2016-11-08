package targetInterfaces;

import firstOrmLibrary.IFirstOrm;
import models.intefaces.IDbEntity;
import secondOrmLibrary.ISecondOrm;

public class AdapterOrm implements ITarget{
	
	IFirstOrm<IDbEntity> firstOrm;
	ISecondOrm secondOrm;
	IDbEntity entity;
	
	public void CreateFirstOrm() {
		firstOrm.Create(entity);	
	}

	public ITarget ReadFirstOrm(int id) {
		return (ITarget) firstOrm.Read(id);
	}

	public void UpdateFirstOrm() {
		firstOrm.Update(entity); 
	}

	public void DeleteFirstOrm() {
		firstOrm.Delete(entity);
	}
	
	public  ISecondOrm getContextSecondOrm() {
		return (ISecondOrm) secondOrm.getContext();
	}

}

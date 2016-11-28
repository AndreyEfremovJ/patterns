package targetInterfaces;

import firstOrmLibrary.IFirstOrm;
import models.intefaces.IDbEntity;

public abstract class AdapterFirstOrm implements ITarget{
	
	IFirstOrm<IDbEntity> firstOrm;
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
}

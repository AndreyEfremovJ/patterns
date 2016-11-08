package firstOrmLibrary;

public interface IFirstOrm<IDbEntity> {
	
    void Create(IDbEntity entity);
    IDbEntity Read(int id);
    void Update(IDbEntity entity);
    void Delete(IDbEntity entity);
    
}

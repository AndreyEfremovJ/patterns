package targetInterfaces;

public interface ITarget {
	
    void CreateFirstOrm();
    ITarget ReadFirstOrm(int id);
    void UpdateFirstOrm();
    void DeleteFirstOrm();
    
    ITarget getContext();
	
}

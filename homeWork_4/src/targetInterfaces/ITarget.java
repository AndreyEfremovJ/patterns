package targetInterfaces;

import secondOrmLibrary.ISecondOrm;

public interface ITarget {
	
    void CreateFirstOrm();
    ITarget ReadFirstOrm(int id);
    void UpdateFirstOrm();
    void DeleteFirstOrm();
    
    ISecondOrm getContextSecondOrm();
	
}

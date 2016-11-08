package secondOrmLibrary;

import java.util.HashSet;

import models.DbUserEntity;
import models.DbUserInfoEntity;

public interface ISecondOrm {
	
	ISecondOrmContext getContext();
}

interface ISecondOrmContext{
   
    HashSet<DbUserEntity> getUsers();
    HashSet<DbUserInfoEntity> getUserInfos();

}
package com.example.multiprojectmain.infrastructure.persistence.doma.dao;

import com.example.multiprojectmain.infrastructure.persistence.doma.entity.MessageInformation;
import org.seasar.doma.Dao;
import org.seasar.doma.Delete;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.Update;
import org.seasar.doma.boot.ConfigAutowireable;

import java.util.List;

@Dao
@ConfigAutowireable
public interface MessageInformationDao {

    @Select
    MessageInformation selectById(Integer id);

    @Select
    List<MessageInformation> selectAll();

    @Insert
    int insert(MessageInformation messageInformation);

    @Update
    int update(MessageInformation messageInformation);

    @Delete
    int delete(MessageInformation messageInformation);

}

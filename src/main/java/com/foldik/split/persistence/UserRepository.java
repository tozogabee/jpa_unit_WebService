package com.foldik.split.persistence;

import com.foldik.split.persistence.model.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by java on 2017.09.07..
 */
public interface UserRepository extends CrudRepository<User,Long> {
}

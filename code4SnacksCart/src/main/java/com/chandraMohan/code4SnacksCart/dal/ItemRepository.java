package com.chandraMohan.code4SnacksCart.dal;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.chandraMohan.code4SnacksCart.entity.Item;


//We can use "CrudRepository" here also but "JpaRepository" provides more extensible features
public interface ItemRepository extends JpaRepository<Item, Integer> {
	
	//Native Query
//	@Query(value="SELECT * FROM  item WHERE description LIKE :desc% LIMIT 4", nativeQuery=true)
//	List<Item> getItemByDesc(@Param("desc") String desc);
	
	//Alternate to implement "Native Query" is "NamedNative Query" at entity level
	@Query(name="Item.getItemByDesc", nativeQuery = true)
	List<Item> getItemByDesc(String desc);
}

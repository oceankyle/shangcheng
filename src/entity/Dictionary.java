package entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity(name="system_dictionary")
public class Dictionary {
	
	@Id  
    @GeneratedValue(strategy = GenerationType.IDENTITY)  
	private int id; //ID
	
	private String name; //名称
	
	private String code;//编码
	
	private int parentId; //父类型ID
	
	private int level; //等级
	
	 @Transient
	private List<Dictionary> children;//子节点
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public int getParentId() {
		return parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}

	public List<Dictionary> getChildren() {
		return children;
	}

	public void setChildren(List<Dictionary> children) {
		this.children = children;
	}
	
	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	
	
	
}

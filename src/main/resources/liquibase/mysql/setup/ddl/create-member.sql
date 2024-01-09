create table tbl_member(
	id bigint unsigned not null AUTO_INCREMENT,
	first_name varchar(100) not null,
        last_name varchar(100) not null,
        academic_title varchar(100) not null,
        scientific_field varchar(100) not null,
        education_field varchar(100) not null,
        department_id bigint unsigned,
	primary key (id),
        constraint department_fk2 FOREIGN KEY (department_id) REFERENCES tbl_department(id) 
)




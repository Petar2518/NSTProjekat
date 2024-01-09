create table tbl_department(
	id bigint unsigned not null AUTO_INCREMENT,
	name varchar(100) not null,
        short_name varchar(100),
        rukovodilac bigint unsigned,
        sekretar bigint unsigned,
	primary key (id)
) 

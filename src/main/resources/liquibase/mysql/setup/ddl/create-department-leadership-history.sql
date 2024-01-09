create table tbl_dlh(
	id bigint unsigned not null AUTO_INCREMENT,
	start_date date not null,
        end_date date ,
        department_id bigint unsigned not null,
        rukovodilac bigint unsigned not null,
        sekretar bigint unsigned,
	primary key (id),
        constraint department_fk3 FOREIGN KEY (department_id) REFERENCES tbl_department(id),
        constraint rukovodilac_fk2 FOREIGN KEY (rukovodilac) REFERENCES tbl_member(id),
        constraint sekretar_fk2 FOREIGN KEY (sekretar) REFERENCES tbl_member(id) 
)


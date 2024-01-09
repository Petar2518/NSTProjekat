create table tbl_ath(
	id bigint unsigned not null AUTO_INCREMENT,
	start_date date not null,
        end_date date ,
        academic_title varchar(100) not null,
        scientific_field varchar(100) not null,
        member_id bigint unsigned,
	primary key (id),
        constraint member_fk FOREIGN KEY (member_id) REFERENCES tbl_member(id) 
)



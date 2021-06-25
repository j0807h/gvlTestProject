#comment

USE test1;

create table COMMENT(
	co_num INTEGER,
	board_num INTEGER,
	co_content VARCHAR(500),
	co_writer VARCHAR(20),
	co_reg TIMESTAMP(6)
);

SELECT * FROM COMMENT;


insert into comment ( co_num,	board_num, co_content, co_writer, co_reg)
		VALUES( 1, 4,"내용","wjdghk",now() )
		
select if(co_num == NULL, 1,(SELECT COUNT(*)+1 FROM comment)) from comment;
SELECT * FROM comment;

SELECT COUNT(*)+1 FROM comment

delete FROM comment WHERE board_num=NULL;
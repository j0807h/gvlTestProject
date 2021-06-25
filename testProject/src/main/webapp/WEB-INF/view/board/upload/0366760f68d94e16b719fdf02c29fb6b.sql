#reply

USE test1;

CREATE TABLE reply(
	board_num INTEGER,        
	reply_num INTEGER,        
	reply_WRITER   VARCHAR(20),
	reply_del_flag   VARCHAR(1),
	reply_memo  VARCHAR(500),
	reply_parent INTEGER,
	reply_depth INTEGER,
	reply_order integer
);

SELECT * FROM reply;

UPDATE reply
SET reply_parent=reply_num, reply_DEPTH=0, reply_ORDER=reply_num;



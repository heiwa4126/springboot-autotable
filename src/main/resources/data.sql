begin;
MERGE INTO WORD(english,japanese) values('apple','りんご');
MERGE INTO WORD(english,japanese) values('banana','バナナ');
MERGE INTO WORD(english,japanese) values('cherry','さくらんぼ');
MERGE INTO WORD(english,japanese) values('deer','しか');
MERGE INTO WORD(english,japanese) values('eel','うなぎ');
commit;
begin;
INSERT INTO WORD(english,japanese) values('apple','りんご') ON CONFLICT (english) DO NOTHING;
INSERT INTO WORD(english,japanese) values('banana','バナナ') ON CONFLICT (english) DO NOTHING;
INSERT INTO WORD(english,japanese) values('cherry','さくらんぼ') ON CONFLICT (english) DO NOTHING;
INSERT INTO WORD(english,japanese) values('deer','しか') ON CONFLICT (english) DO NOTHING;
INSERT INTO WORD(english,japanese) values('eel','うなぎ') ON CONFLICT (english) DO NOTHING;
INSERT INTO WORD(english,japanese) values('fox','きつね') ON CONFLICT (english) DO NOTHING;
commit;
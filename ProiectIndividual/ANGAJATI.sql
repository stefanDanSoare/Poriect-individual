DROP TABLE angajat;

CREATE TABLE angajat (

 nume                   VARCHAR2(10)  NOT NULL,

 email                  VARCHAR(25),

 post                   VARCHAR2(9),

 salariu                VARCHAR(25),

 contact                VARCHAR(25),

 ang_id                 VARCHAR(25),

 CONSTRAINT angajat_PRIMARY_KEY PRIMARY KEY (nume));

insert into angajat values('soare', 'stefan.soare02@e-uvt.ro','student','0','0712345678', '1001');
insert into angajat values('nicu', 'a.soare02@e-uvt.ro','student','10','0712345670', '1011');
insert into angajat values('andrei', 'b.soare02@e-uvt.ro','student','20','0712345671', '1021');
insert into angajat values('alex', 'c.soare02@e-uvt.ro','student','30','0712345672', '1031');
insert into angajat values('george', 'd.soare02@e-uvt.ro','student','40','0712345673', '1041');
insert into angajat values('viorel', 'e.soare02@e-uvt.ro','student','50','0712345674', '1051');
insert into angajat values('vasile', 'f.soare02@e-uvt.ro','student','60','0712345675', '1061');
insert into angajat values('razvan', 'g.soare02@e-uvt.ro','student','70','0712345676', '1071');
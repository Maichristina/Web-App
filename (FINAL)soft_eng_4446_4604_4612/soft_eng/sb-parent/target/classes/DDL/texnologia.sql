use texnlog;


create table login 
	(pword int ,username varchar(30));


create table courses
	(id int not null auto_increment ,semester int not null,name varchar(30),syllabus varchar(250),professor varchar(45),primary key(`id`))
    ENGINE=InnoDB AUTO_INCREMENT=1 default CHARSET=latin1;
    

create table student 
	(am int AUTO_INCREMENT,id int default 1, firstname varchar(30), lastname VARCHAR(30),semester int not null,
    finalgrade double not null,projectgrade double not null,examgrade double not null ,primary key(`am`),foreign key (id) references `courses` (`id`) ON DELETE CASCADE )
    ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1 ;

insert into login values 
(65432,"user1"),
(3457832,"user2"),
(87653,"user3"),
(45678,"user4"),
(146378,"user5");

insert into `courses` values 
(1,1,"apeirostikos","migadiki kai sinartiseis","kathigitis1"),
(2,2,"java","op programming","kathigitis2"),
(3,3,"digital design","breadboard","kathigitis3"),
(4,5,"theory of computation","turing machines ","kathigitis4"),
(5,7,"computer graphics","game designing","kathigitis5"),
(6,7,"data base","the basics of sql","kathigitis6"),
(7,3,"Probabilities and statistics","introduction to statistics","kathigitis7"),
(8,4,"Numeral Analysis","mathematical analysis","kathigitis8"),
(9,4,"Electronics","transistors","kathigitis9"),
(10,6,"Artificial Intelligence","algorithms","kathigitis10");
    
insert into `student` values
(1,1,"afroditi","vamva",8,7.0,9.0,10.0),
(2,2,"xristina","mai",8,9.0,9.0,9.0),
(3,3,"sofia","moisiadou",8,7.0,7.5,6.7),
(4,4,"maria","pappadopoulou",7,3.3,4.4,6.6),
(5,7,"giorgos","pappadopoulos",8,5.8,3.2,1.7),
(6,5,"konstantinos","papakonstantinou",8,6.0,6.5,4.6),
(7,6,"eleni","vlaxaki",8,7.0,9.0,10.0),
(8,9,"nikos","nikolaou",8,1.2,6.6,2.0),
(9,10,"vasilis","vasilopoulos",8,1.7,3.0,4.2),
(10,8,"panagiotis","panagiotopoulos",8,9.0,10.0,9.0);








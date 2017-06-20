-- when user from 'persistence.xml' -- >  <property name="javax.persistence.schema-generation.database.action" value="drop-and-create"/>

INSERT INTO user (`firstName`, `lastName`, `login`,`password`,`email`) VALUES ('john', 'adamecki', 'aaa', 'aaa','123@wp.pl');

INSERT INTO partner (`firstName`, `lastName`, `login`,`password`,`email`) VALUES ('adam', 'adamecki', 'a', 'a','a@wp.pl');
INSERT INTO partner (`firstName`, `lastName`, `login`,`password`,`email`) VALUES ('beata', 'batycka', 'b', 'b','b@wp.pl');
INSERT INTO partner (`firstName`, `lastName`, `login`,`password`,`email`) VALUES ('celina', 'cwaniacka', 'c', 'c','c@wp.pl');

-- when user from 'persistence.xml' -- > hibernate properties

-- INSERT INTO `fxdatabase`.`user` (`firstName`, `lastName`, `login`,`password`,`email`) VALUES ('john', 'adamecki', 'aaa', 'aaa','123@wp.pl');

-- INSERT INTO `fxdatabase`.`partner` (`firstName`, `lastName`, `login`,`password`,`email`) VALUES ('adam', 'adamecki', 'a', 'a','a@wp.pl');
-- INSERT INTO `fxdatabase`.`partner` (`firstName`, `lastName`, `login`,`password`,`email`) VALUES ('beata', 'batycka', 'b', 'b','b@wp.pl');
-- INSERT INTO `fxdatabase`.`partner` (`firstName`, `lastName`, `login`,`password`,`email`) VALUES ('celina', 'cwaniacka', 'c', 'c','c@wp.pl');

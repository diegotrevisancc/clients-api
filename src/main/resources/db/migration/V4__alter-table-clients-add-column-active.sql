alter table clients add active tinyint;
update clients set active = 1;
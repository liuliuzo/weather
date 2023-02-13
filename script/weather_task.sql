drop table if exists `weather_task`;
create table `weather_task` (
 `id` varchar(30) NOT NULL,
 `cron_name` varchar(30) NULL,
 `cron` varchar(30) NOT NULL,
 `gmt_create` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
 `gmt_modified` datetime DEFAULT NULL,
 PRIMARY KEY (`id`) USING BTREE
);
insert into `weather_task`(id, cron_name, cron, gmt_create)  values ('1','每隔1分钟执行一次','0 */1 * * * ?', current_timestamp);
insert into `weather_task`(id, cron_name, cron, gmt_create)  values ('2','每隔5秒执行一次','*/5 * * * * ?', current_timestamp);
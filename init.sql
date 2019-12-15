DROP TABLE IF EXISTS `message_information`;
CREATE TABLE `message_information` (
    `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
    `message` varchar(255) NOT NULL DEFAULT '',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

INSERT INTO `message_information` (`id`, `message`) VALUES (1,'こんにちは。');

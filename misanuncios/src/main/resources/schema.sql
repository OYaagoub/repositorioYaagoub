INSERT INTO `categories` (`id`, `name`) VALUES
(1, 'Coches'),
(2, 'Motos'),
(3, 'Motor y Accesorios'),
(4, 'Moda y Accesorios'),
(5, 'Inmobiliaria'),
(6, 'Tecnología y Electrónica'),
(7, 'Deporte y Ocio'),
(8, 'Hogar y Jardín'),
(9, 'Otros');


INSERT INTO `roles` (`id`, `name`) VALUES
(1, 'admin'),
(2, 'user');


INSERT INTO `permissions` (`id`, `name`) VALUES
(1, 'editar'),
(2, 'borrar'),
(3, 'añadir');



INSERT INTO `role_has_permissions` (`permission_id`, `role_id`) VALUES
(1, 1),
(1, 2),
(2, 1),
(2, 2),
(3, 1),
(3, 2);
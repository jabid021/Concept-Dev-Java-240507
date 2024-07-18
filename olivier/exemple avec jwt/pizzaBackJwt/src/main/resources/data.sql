insert into ingredient(ingredient_name) values('jambon');
insert into ingredient(ingredient_name) values('oignon');
insert into ingredient(ingredient_name) values('olive');
insert into ingredient(ingredient_name) values('mozarella');

insert into pate(pate_name) values('fine');
insert into pate(pate_name) values('epaisse');
insert into pate(pate_name) values('soufflee');

insert into pizza(pizza_name,pizza_pate_id) values('regina fine',1);
insert into pizza(pizza_name,pizza_pate_id) values('regina epaisse',2);
insert into pizza(pizza_name,pizza_pate_id) values('calzone',2);

insert into pizza_ingredient(pizza_ingredient_ingredient_id,pizza_ingredient_pizza_id) values(1,1);
insert into pizza_ingredient(pizza_ingredient_ingredient_id,pizza_ingredient_pizza_id) values(4,1);
insert into pizza_ingredient(pizza_ingredient_ingredient_id,pizza_ingredient_pizza_id) values(1,2);
insert into pizza_ingredient(pizza_ingredient_ingredient_id,pizza_ingredient_pizza_id) values(4,2);
insert into pizza_ingredient(pizza_ingredient_ingredient_id,pizza_ingredient_pizza_id) values(1,3);
insert into pizza_ingredient(pizza_ingredient_ingredient_id,pizza_ingredient_pizza_id) values(4,3);

insert into regions (id, nom) values (1, "Bordeaux");
insert into regions (id, nom) values (2, "Alsace");
insert into regions (id, nom) values (3, "Loire");

insert into couleurs (id, nom) values (1, "Rouge");
insert into couleurs (id, nom) values (2, "Blanc");
insert into couleurs (id, nom) values (3, "Rosé");


insert into bouteilles (millesime, nom, petillant, quantite, couleur_id, region_id)  values (2014, "Château Le puy", 0, 12, 1, 1 );
insert into bouteilles (millesime, nom, petillant, quantite, couleur_id, region_id)  values (1989, "Bourgueil rosé", 0, 25, 3, 3 );
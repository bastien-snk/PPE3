-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Hôte : db
-- Généré le : ven. 28 mai 2021 à 16:24
-- Version du serveur :  5.7.33
-- Version de PHP : 7.4.16

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `ppe3`
--

-- --------------------------------------------------------

--
-- Structure de la table `categories`
--

CREATE TABLE `categories` (
  `idCategorie` int(11) NOT NULL,
  `nom` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `description` text COLLATE utf8mb4_unicode_ci,
  `image` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Déchargement des données de la table `categories`
--

INSERT INTO `categories` (`idCategorie`, `nom`, `description`, `image`) VALUES
(1, 'Vapoteuses', 'Du matériel de pointe pour les experts de la vape, comme pour les petits joueurs !', 'vape-corps-article.jpg'),
(2, 'e-Liquide', 'Découvrez notre vaste gamme de e-liquide !\r\n\r\nDu fruité, du gourmand, du frais, avec ou sans nicotine, retrouvez vos liquides préférés ici !', 'eLiquide.jpg'),
(3, 'Chargeurs', 'Il viendra bien un moment ou vous aurez besoin d\'énergie non ?', 'chargeurs.jpg'),
(5, 'Résistances', 'Toutes les résistances pour votre matériel ! On peux dire que ça va chauffer...', 'resistance.jpg');

-- --------------------------------------------------------

--
-- Structure de la table `clients`
--

CREATE TABLE `clients` (
  `idClient` int(11) NOT NULL,
  `nomClient` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `prenomClient` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `emailClient` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `telephoneClient` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Structure de la table `client_user`
--

CREATE TABLE `client_user` (
  `id` int(11) NOT NULL,
  `email` varchar(180) COLLATE utf8mb4_unicode_ci NOT NULL,
  `roles` json NOT NULL,
  `password` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `nom` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `prenom` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `telephone` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Déchargement des données de la table `client_user`
--

INSERT INTO `client_user` (`id`, `email`, `roles`, `password`, `nom`, `prenom`, `telephone`) VALUES
(1, 'test@gmail.com', '[\"ROLE_USER\"]', '$argon2id$v=19$m=65536,t=4,p=1$bli59Hy3/Wq1rbHgKB20ig$blUevNuN7HM4gn3Ytla6FxfFnTJH1L/75NCpm8LO0XU', '', '', '');

-- --------------------------------------------------------

--
-- Structure de la table `comporter`
--

CREATE TABLE `comporter` (
  `idProduit` int(11) NOT NULL,
  `idVente` int(11) NOT NULL,
  `quantite` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Déchargement des données de la table `comporter`
--

INSERT INTO `comporter` (`idProduit`, `idVente`, `quantite`) VALUES
(1, 11, 11),
(1, 12, 11),
(1, 13, 11),
(1, 14, 11),
(2, 11, 2),
(2, 12, 10),
(3, 13, 10);

-- --------------------------------------------------------

--
-- Structure de la table `comptes_agents`
--

CREATE TABLE `comptes_agents` (
  `idAgent` int(11) NOT NULL,
  `email` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `username` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `telephone` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `password` varchar(75) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `idProfil` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Déchargement des données de la table `comptes_agents`
--

INSERT INTO `comptes_agents` (`idAgent`, `email`, `username`, `telephone`, `password`, `idProfil`) VALUES
(1, 'admin@vape.shop', 'admin', '911', 'admin', 1),
(2, 'bruno.mars@vape.shop', 'bruno.mars', '17', '123', 2);

-- --------------------------------------------------------

--
-- Structure de la table `doctrine_migration_versions`
--

CREATE TABLE `doctrine_migration_versions` (
  `version` varchar(191) COLLATE utf8_unicode_ci NOT NULL,
  `executed_at` datetime DEFAULT NULL,
  `execution_time` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Structure de la table `produits`
--

CREATE TABLE `produits` (
  `idProduit` int(11) NOT NULL,
  `prix` decimal(15,2) NOT NULL,
  `nomProduit` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `quantite` int(11) DEFAULT NULL,
  `description` text COLLATE utf8mb4_unicode_ci,
  `image` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `evaluations` double NOT NULL,
  `idCategorie` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Déchargement des données de la table `produits`
--

INSERT INTO `produits` (`idProduit`, `prix`, `nomProduit`, `quantite`, `description`, `image`, `evaluations`, `idCategorie`) VALUES
(1, '35.00', 'Vaporesso Kit (Gen Nano)', 11, 'tttt', '1/', 3.5, 1),
(2, '34.90', 'VAPORESSO (Stick Sky Solo) Plus', 10, NULL, '2/', 0, 1),
(3, '59.90', 'Kit Aegis Max (Geek Vapes)', 25, 'Le kit Aegis Max est la grande soeur de la box Aegis Solo de chez Geek Vapes. Elle peu accueillir 1 accu 20700/21700 ou 18650 (non fournis) avec l\'adaptateur inclus dans le kit. Les accus pourrons se recharger via le port Micro USB présent sur la box. En fonction de l\'accu utilisé, elle pourra vous fournir jusqu\'à 100W de puissance max.\r\n\r\nSur sa tranche vous trouverez un écran Oled de 0,96\" qui vous permettra de voir l\'autonomie de batterie restante et la puissance à laquelle vous vapez.\r\n\r\nLa box embarque avec elle, l\'incontournable clearomiseur Zeus Sub-Ohm. Il dispose d\'une contenance de 5ml et son remplissage s\'effectuera par le haut. Il dispose d\'une arrivée d\'air (air-flow) réglable sur le haut et le remplacement de ses résistance se fera par sa base. Les résistances du Zeus sont en Mesh, vous aurez donc un excellent rendu des saveurs avec ce dernier.', '3/', 4.5, 1),
(4, '44.90', 'Aspire (Kit Nautilus Prime X)', NULL, '“Enfin le premier Pod Mod 18650 compatible résistances Nautilus.\r\n\r\nVa-t-on enfin trouver le pod mod ultime ?\r\n\r\nEn tout cas sur le papier ça promet !”\r\n\r\nOptimisé pour être plus ergonomique que son prédécesseur, Nautilus Prime X conserve toujours la grande fonctionnalité et les caractéristiques élégantes de la version précédente.\r\n\r\nConstruit pour s\'adapter à une batterie externe 18650 (non fournis), il est maintenant mis à niveau avec un écran couleur TFT de 0,96\" avec un meilleur placement des boutons de volume pour une expérience utilisateur améliorée.\r\n\r\nÉquipé d\'un flux d\'air réglable, Nautilus Prime X est également doté des résistances Nautilus/BP et RBA pour plus de flexibilité.\r\n\r\nOffrant une large plage de puissance, jusqu\'à 60W, Nautilus Prime X assure la stabilité de ses performances de sortie malgré son facteur de forme compact.  \r\n\r\n', '4/', 4.8, 1),
(5, '44.90', 'Eleaf (Ijust 21700)', NULL, 'Le iJust 21700 avec ELLO Duro (version 5.5ml) est la version mise à jour de la série Eleaf iJust, offrant une puissance maximale de 80 watts avec une seule batterie 21700/18650 (vendu séparément). \r\nCe n\'est pas simplement un beau kit de style tube puisqu\'il présente les dernières bobines HW-M2 et HW-N2 qui bénéficient d\'une technologie innovante anti-fuite et autonettoyante (LPSC). \r\nCes deux bobines permettent également un flux d\'air plus uniforme et utilisent du coton poreux comme matériau absorbant pour absorber complètement et rapidement le liquide électronique, vous offrant ainsi une expérience de vapotage sans précédent. \r\n', '5/', 4, 1),
(6, '25.90', 'DIGIFLAVOR (Kit Helix)', 10, 'le Kit Helix est un élégant kit de démarrage en 18650 . \r\n\r\nConstruit avec un matériau ABS ultra-léger de haute qualité qui augmente la résistance aux chocs et à la chaleur. \r\n\r\nTrois modes de sortie de puissance sont disponibles pour correspondre à vos préférences personnelles.', '6/', 3.5, 1);

-- --------------------------------------------------------

--
-- Structure de la table `profils`
--

CREATE TABLE `profils` (
  `idProfil` int(11) NOT NULL,
  `type` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Déchargement des données de la table `profils`
--

INSERT INTO `profils` (`idProfil`, `type`) VALUES
(1, 'ADMINISTRATOR'),
(2, 'AGENT');

-- --------------------------------------------------------

--
-- Structure de la table `ventes`
--

CREATE TABLE `ventes` (
  `idVente` int(11) NOT NULL,
  `dateVente` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `chiffreAffaire` double NOT NULL,
  `idClient` int(11) DEFAULT NULL,
  `idAgent` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Déchargement des données de la table `ventes`
--

INSERT INTO `ventes` (`idVente`, `dateVente`, `chiffreAffaire`, `idClient`, `idAgent`) VALUES
(3, '444444', 444, 1, 1),
(4, '2021-04-04', 0, 1, 1),
(5, '5/4/121', 0, 1, 1),
(6, '5/4/121', 0, 1, 1),
(7, '5/4/121', 0, 1, 1),
(8, '5/4/121', 0, 1, 1),
(9, '5/4/121', 0, 1, 1),
(10, '5/4/121', 0, 1, 1),
(11, '5/4/121', 0, 1, 1),
(12, '5/4/121', 0, 1, 1),
(13, '5/4/121', 0, 1, 1),
(14, '5/4/121', 0, 1, 1);

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `categories`
--
ALTER TABLE `categories`
  ADD PRIMARY KEY (`idCategorie`),
  ADD UNIQUE KEY `nom` (`nom`);

--
-- Index pour la table `clients`
--
ALTER TABLE `clients`
  ADD PRIMARY KEY (`idClient`);

--
-- Index pour la table `client_user`
--
ALTER TABLE `client_user`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UNIQ_5C0F152BE7927C74` (`email`);

--
-- Index pour la table `comporter`
--
ALTER TABLE `comporter`
  ADD PRIMARY KEY (`idProduit`,`idVente`),
  ADD KEY `IDX_4442FCC9391C87D5` (`idProduit`),
  ADD KEY `IDX_4442FCC99F4E6951` (`idVente`);

--
-- Index pour la table `comptes_agents`
--
ALTER TABLE `comptes_agents`
  ADD PRIMARY KEY (`idAgent`),
  ADD KEY `idProfil` (`idProfil`);

--
-- Index pour la table `doctrine_migration_versions`
--
ALTER TABLE `doctrine_migration_versions`
  ADD PRIMARY KEY (`version`);

--
-- Index pour la table `produits`
--
ALTER TABLE `produits`
  ADD PRIMARY KEY (`idProduit`),
  ADD KEY `idCategorie` (`idCategorie`);

--
-- Index pour la table `profils`
--
ALTER TABLE `profils`
  ADD PRIMARY KEY (`idProfil`);

--
-- Index pour la table `ventes`
--
ALTER TABLE `ventes`
  ADD PRIMARY KEY (`idVente`),
  ADD KEY `idClient` (`idClient`),
  ADD KEY `idAgent` (`idAgent`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `categories`
--
ALTER TABLE `categories`
  MODIFY `idCategorie` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT pour la table `clients`
--
ALTER TABLE `clients`
  MODIFY `idClient` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `client_user`
--
ALTER TABLE `client_user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT pour la table `comptes_agents`
--
ALTER TABLE `comptes_agents`
  MODIFY `idAgent` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT pour la table `produits`
--
ALTER TABLE `produits`
  MODIFY `idProduit` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT pour la table `profils`
--
ALTER TABLE `profils`
  MODIFY `idProfil` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT pour la table `ventes`
--
ALTER TABLE `ventes`
  MODIFY `idVente` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `comporter`
--
ALTER TABLE `comporter`
  ADD CONSTRAINT `FK_4442FCC9391C87D5` FOREIGN KEY (`idProduit`) REFERENCES `produits` (`idProduit`),
  ADD CONSTRAINT `FK_4442FCC99F4E6951` FOREIGN KEY (`idVente`) REFERENCES `ventes` (`idVente`);

--
-- Contraintes pour la table `comptes_agents`
--
ALTER TABLE `comptes_agents`
  ADD CONSTRAINT `FK_7A1B07A285C71A0D` FOREIGN KEY (`idProfil`) REFERENCES `profils` (`idProfil`);

--
-- Contraintes pour la table `produits`
--
ALTER TABLE `produits`
  ADD CONSTRAINT `FK_BE2DDF8CB597FD62` FOREIGN KEY (`idCategorie`) REFERENCES `categories` (`idCategorie`);

--
-- Contraintes pour la table `ventes`
--
ALTER TABLE `ventes`
  ADD CONSTRAINT `FK_64EC489A314FDF80` FOREIGN KEY (`idAgent`) REFERENCES `comptes_agents` (`idAgent`),
  ADD CONSTRAINT `FK_64EC489AA455ACCF` FOREIGN KEY (`idClient`) REFERENCES `client_user` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

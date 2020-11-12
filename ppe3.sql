-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Hôte : db
-- Généré le : mer. 04 nov. 2020 à 10:40
-- Version du serveur :  5.7.31
-- Version de PHP : 7.4.9

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
  `nom` varchar(50) COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Déchargement des données de la table `categories`
--

INSERT INTO `categories` (`idCategorie`, `nom`) VALUES
(6, 'Auto Clicker'),
(2, 'Ghost Client'),
(3, 'Hacked Client'),
(1, 'Injected Client'),
(4, 'Memory Client');

-- --------------------------------------------------------

--
-- Structure de la table `clients`
--

CREATE TABLE `clients` (
  `idClient` int(11) NOT NULL,
  `nomClient` varchar(50) COLLATE utf8_bin NOT NULL,
  `prenomClient` varchar(50) COLLATE utf8_bin NOT NULL,
  `emailClient` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `telephoneClient` varchar(50) COLLATE utf8_bin DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Déchargement des données de la table `clients`
--

INSERT INTO `clients` (`idClient`, `nomClient`, `prenomClient`, `emailClient`, `telephoneClient`) VALUES
(1, 'LaD', 'Koba', 'koba@bat.vii', '+33 911'),
(2, 'AjouterA', 'Un', 'Client', 'Mec'),
(3, 'CUNY', 'Enzo', 'zozo404@gmail.com', '18');

-- --------------------------------------------------------

--
-- Structure de la table `comporter`
--

CREATE TABLE `comporter` (
  `idProduit` int(11) NOT NULL,
  `idVente` int(11) NOT NULL,
  `quantite` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Déchargement des données de la table `comporter`
--

INSERT INTO `comporter` (`idProduit`, `idVente`, `quantite`) VALUES
(1, 1, 4),
(1, 4, 12),
(1, 5, 1),
(1, 6, 1),
(1, 7, 15),
(1, 9, 1),
(1, 10, 1),
(1, 11, 1),
(1, 13, 1),
(1, 14, 1),
(1, 16, 1),
(1, 17, 1),
(1, 23, 1),
(1, 27, 1),
(1, 28, 1),
(1, 29, 1),
(1, 30, 1),
(1, 31, 1),
(1, 32, 1),
(1, 33, 2),
(1, 34, 2),
(1, 35, 10);

-- --------------------------------------------------------

--
-- Structure de la table `comptes_agents`
--

CREATE TABLE `comptes_agents` (
  `idAgent` int(11) NOT NULL,
  `email` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `username` varchar(50) COLLATE utf8_bin NOT NULL,
  `telephone` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `password` varchar(75) COLLATE utf8_bin DEFAULT NULL,
  `idProfil` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Déchargement des données de la table `comptes_agents`
--

INSERT INTO `comptes_agents` (`idAgent`, `email`, `username`, `telephone`, `password`, `idProfil`) VALUES
(1, 'admin@contact.me', 'admin', '911', 'admin', 1),
(4, 'email', 'username', '911', 'password', 10),
(6, 'walidsax@prod.wav', 'WALIDSAX', '9111', '123', 1);

-- --------------------------------------------------------

--
-- Structure de la table `produits`
--

CREATE TABLE `produits` (
  `idProduit` int(11) NOT NULL,
  `prix` decimal(15,2) NOT NULL,
  `nomProduit` varchar(50) COLLATE utf8_bin NOT NULL,
  `quantite` int(11) DEFAULT NULL,
  `image` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `evaluations` float NOT NULL,
  `idCategorie` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Déchargement des données de la table `produits`
--

INSERT INTO `produits` (`idProduit`, `prix`, `nomProduit`, `quantite`, `image`, `evaluations`, `idCategorie`) VALUES
(1, '50.00', 'Vape Lite (Lifetime)', 1, NULL, 4.7, 1),
(2, '35.00', 'Vape V3', 1000000, 'vape.png', 4.8, 2),
(3, '30.00', 'Vape V2', 5, 'vape.png', 4.4, 2),
(4, '10.00', 'MantheClicker', 5, 'manthe.png', 3.8, 6);

-- --------------------------------------------------------

--
-- Structure de la table `profils`
--

CREATE TABLE `profils` (
  `idProfil` int(11) NOT NULL,
  `type` varchar(50) COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Déchargement des données de la table `profils`
--

INSERT INTO `profils` (`idProfil`, `type`) VALUES
(1, 'ADMINISTRATOR'),
(10, 'AGENT');

-- --------------------------------------------------------

--
-- Structure de la table `ventes`
--

CREATE TABLE `ventes` (
  `idVente` int(11) NOT NULL,
  `dateVente` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `chiffreAffaire` double NOT NULL,
  `idClient` int(11) NOT NULL,
  `idAgent` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Déchargement des données de la table `ventes`
--

INSERT INTO `ventes` (`idVente`, `dateVente`, `chiffreAffaire`, `idClient`, `idAgent`) VALUES
(1, '2014-10-20', 500000, 3, 6),
(3, '3/9/120', 0, 1, 1),
(4, '3/9/120', 0, 1, 1),
(5, '3/9/120', 0, 1, 1),
(6, '3/9/120', 0, 1, 1),
(7, '3/9/120', 0, 1, 1),
(8, '3/9/120', 0, 1, 1),
(9, '3/9/120', 0, 1, 1),
(10, '3/9/120', 0, 1, 1),
(11, '3/9/120', 0, 1, 1),
(12, '3/9/120', 0, 1, 1),
(13, '3/9/120', 0, 1, 1),
(14, '3/9/120', 0, 1, 1),
(15, '3/9/120', 0, 1, 1),
(16, '3/9/120', 0, 1, 1),
(17, '3/9/120', 0, 1, 1),
(18, '3/9/120', 0, 1, 1),
(20, '3/9/120', 0, 1, 1),
(22, '3/9/120', 0, 1, 1),
(23, '3/9/120', 0, 1, 1),
(24, '3/9/120', 0, 1, 1),
(25, '3/9/120', 0, 1, 1),
(26, '3/9/120', 0, 1, 1),
(27, '3/9/120', 0, 1, 1),
(28, '3/9/120', 0, 1, 1),
(29, '3/9/120', 0, 1, 1),
(30, '3/9/120', 0, 1, 1),
(31, '3/9/120', 0, 1, 1),
(32, '3/9/120', 0, 1, 1),
(33, '3/9/120', 0, 1, 1),
(34, '3/9/120', 0, 1, 1),
(35, '3/9/120', 0, 1, 1);

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
-- Index pour la table `comporter`
--
ALTER TABLE `comporter`
  ADD PRIMARY KEY (`idProduit`,`idVente`),
  ADD KEY `idVente` (`idVente`);

--
-- Index pour la table `comptes_agents`
--
ALTER TABLE `comptes_agents`
  ADD PRIMARY KEY (`idAgent`),
  ADD KEY `idProfil` (`idProfil`);

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
  MODIFY `idCategorie` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT pour la table `clients`
--
ALTER TABLE `clients`
  MODIFY `idClient` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT pour la table `comptes_agents`
--
ALTER TABLE `comptes_agents`
  MODIFY `idAgent` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT pour la table `produits`
--
ALTER TABLE `produits`
  MODIFY `idProduit` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT pour la table `profils`
--
ALTER TABLE `profils`
  MODIFY `idProfil` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT pour la table `ventes`
--
ALTER TABLE `ventes`
  MODIFY `idVente` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=36;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `comporter`
--
ALTER TABLE `comporter`
  ADD CONSTRAINT `comporter_ibfk_1` FOREIGN KEY (`idProduit`) REFERENCES `produits` (`idProduit`),
  ADD CONSTRAINT `comporter_ibfk_2` FOREIGN KEY (`idVente`) REFERENCES `ventes` (`idVente`);

--
-- Contraintes pour la table `comptes_agents`
--
ALTER TABLE `comptes_agents`
  ADD CONSTRAINT `comptes_agents_ibfk_1` FOREIGN KEY (`idProfil`) REFERENCES `profils` (`idProfil`);

--
-- Contraintes pour la table `produits`
--
ALTER TABLE `produits`
  ADD CONSTRAINT `produits_ibfk_1` FOREIGN KEY (`idCategorie`) REFERENCES `categories` (`idCategorie`);

--
-- Contraintes pour la table `ventes`
--
ALTER TABLE `ventes`
  ADD CONSTRAINT `ventes_ibfk_1` FOREIGN KEY (`idClient`) REFERENCES `clients` (`idClient`),
  ADD CONSTRAINT `ventes_ibfk_2` FOREIGN KEY (`idAgent`) REFERENCES `comptes_agents` (`idAgent`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

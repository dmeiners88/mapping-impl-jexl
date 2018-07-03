<h1 align="center">A Zero-Dependency Mapping Library</h1>
<h4 align="center">Simple Java Library to include scripting languages into your Java application.</h4>
<h5 align="center">Apache Commons JEXL Implementation Module</h5>

<p align="center">
  <a href="https://travis-ci.com/dmeiners88/mapping-impl-jexl">
    <img src="https://travis-ci.com/dmeiners88/mapping-impl-jexl.svg?branch=develop"
         alt="Build Status">
  </a>
  <a href="https://sonarcloud.io/dashboard?id=de.dmeiners.mapping%3Amapping-impl-jexl">
    <img src="https://sonarcloud.io/api/project_badges/measure?project=de.dmeiners.mapping%3Amapping-impl-jexl&metric=alert_status" alt="SonarCloud Analysis">
  </a>
  <a href="https://bintray.com/dmeiners/mapping/mapping-impl-jexl/_latestVersion">
    <img src="https://api.bintray.com/packages/dmeiners/mapping/mapping-impl-jexl/images/download.svg" alt="Download">
  </a>
  <a href="https://github.com/dmeiners88/mapping-api/blob/develop/LICENSE">
    <img src="https://img.shields.io/github/license/dmeiners88/mapping-impl-jexl.svg" alt="License">
  </a>
  <a href="https://semver.org/spec/v2.0.0.html">
    <img src="https://img.shields.io/badge/semver-2.0.0-brightgreen.svg" alt="Semantic Versioning">
  </a>
</p>

<p align="center">
  <a href="#features">Features</a> •
  <a href="#installation">Installation</a> •
  <a href="#usage">Usage</a>
</p>

## Features
* Implements the [Mapping API](https://github.com/dmeiners88/mapping-api) (v1.0.0) by delegating to [Apache Commons JEXL](https://commons.apache.org/proper/commons-jexl/)
* Zero dependencies, Apache Commons JEXL shaded for your convenience
* Sandboxed script execution environment

## Installation

### Add the API Module
Add [JCenter](https://bintray.com/bintray/jcenter) as a repository to your Maven POM:
```xml
<repositories>
    <repository>
        <snapshots>
            <enabled>false</enabled>
        </snapshots>
        <id>jcenter</id>
        <name>JCenter</name>
        <url>https://jcenter.bintray.com</url>
    </repository>
</repositories>
```

Add the following dependency:
```xml
<dependency>
    <groupId>de.dmeiners.mapping</groupId>
    <artifactId>mapping-api</artifactId>
    <version>1.0.0</version>
</dependency>
```

### Add the Implementation Module
```xml
<dependency>
    <groupId>de.dmeiners.mapping</groupId>
    <artifactId>mapping-impl-jexl</artifactId>
    <version>1.0.1</version>
</dependency>
```

## Usage

The corresponding [section](https://github.com/dmeiners88/mapping-api#usage) of the API module
applies. See also the [reference](https://commons.apache.org/proper/commons-jexl/reference/index.html)
of the Apache Commons JEXL scripting language.
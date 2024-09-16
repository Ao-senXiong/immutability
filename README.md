# Practical Immutability For Classes And Objects(PICO)

PICO is a type system that supports class level and object level immutability based on Checker Framework.

## How to build 
#### Clone the repository
```bash
git clone git@github.com:Ao-senXiong/immutability.git -b aosen-master
```

#### Go into the directory
```bash
cd immutability
```
#### Build PICO
```bash
./.ci-build-without-test.sh
```

#### Sanity check
```bash
./gradlew ImmutabilityTypecheckTest
```

## How to check immutability property with PICO

#### Check a java file
```bash
./check.sh <path-to-your-java-file>
```

#### Use Do-like-javac with proper dependencies installed
```bash
./run-dljc.sh -t <path-to-your-maven-project>/mvn compile
```

#### Use Gralde with Checker Framework plugin
Add the following to your `build.gradle` file
```bash
plugins {
    // Checker Framework pluggable type-checking
    id 'org.checkerframework' version '0.6.44'
}

apply plugin: 'org.checkerframework'
checkerFramework {
  checkers = [
      'pico.typecheck.PICOChecker'
  ]
  extraJavacArgs = [
    '-Werror',
    '-Astubs=/path/to/my/stub/file.astub'
  ]
}

ext {
    versions = [
        eisopVersion: '3.42.0-eisop1',
    ]
}

dependencies {
    compileOnly "path-to-your-checkerframework-inference-jar"
    compileOnly "io.github.eisop:checker-qual:${versions.eisopVersion}"
    testCompileOnly "io.github.eisop:checker-qual:${versions.eisopVersion}"
    checkerFramework "io.github.eisop:checker:${versions.eisopVersion}"
    checkerFramework "path-to-your-immutability-jar"
}
```


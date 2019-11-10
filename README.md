# Ceiba-Parking
Ceiba-Parking

___
# Git Flow

## Iniciando git flow

```console
$ git branch develop // partiendo de master, se crea develop

$ git push -u origin develop // backup de la rama master

$ git branch -l // lista de ramas creadas en el repo
  develop
* master
```

## Creando Feature

```console
$ git checkout develop // ubicarnos en la rama develop

git flow feature start feature_git_flow_summary // creando nueva feature

$ git checkout develop // ubicarnos en la rama develop

$ git flow feature finish feature_git_flow_summary // finalizamos la feature
```

## Creando Release

```console
$ git flow release start release_0.1.0 // crear release

$ git flow release finish 'elease_0.1.0' // finalizar el release
```

## Creando Hotfix

```console
$ git flow hotfix start hotfix_branch

$ git flow hotfix finish hotfix_branch
```

[atlassian gitflow](https://www.atlassian.com/git/tutorials/comparing-workflows/gitflow-workflow)

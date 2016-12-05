Git global setup

git config --global user.name "Frühauf Maximilian"
git config --global user.email "mf140@hdm-stuttgart.de"

Create a new repository

git clone https://gitlab.mi.hdm-stuttgart.de/mf140/01.git
cd 01
touch README.md
git add README.md
git commit -m "add README"
git push -u origin master

Existing folder or Git repository

cd existing_folder
git init
git remote add origin https://gitlab.mi.hdm-stuttgart.de/mf140/01.git
git add .
git commit
git push -u origin master

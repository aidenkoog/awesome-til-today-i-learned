# how to release study note.
git stash
git pull origin master
git stash pop
git add .
git commit -m "[Feature] Update coding study"
git push origin master
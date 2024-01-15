
#    HOWTO:
#    - Create a directory e.g. PI-Rail
#    - Copy the script inside the folder
#    - Run the script

pimobilecore="https://gitlab.com/pi-mobile/pi-mobile-core"
pimobilefx="https://gitlab.com/pi-mobile/pi-mobile-fx"
pirailbase="https://gitlab.com/pi-rail/pi-rail-base"
pirailclient="https://gitlab.com/pi-rail/pi-rail-client"
pirailfx="https://gitlab.com/pi-rail/pi-rail-fx"
Z21Drive="https://github.com/PI-Data/z21-drive.git"
FxDock="https://github.com/PI-Data/FxDock_PI-Mobile.git"
pirailarduino="https://gitlab.com/pi-rail/pi-rail-arduino.git"
piraildoc="https://gitlab.com/pi-rail/pi-rail-doc.git"


declare -a repolist=("pi-mobile-core::"$pimobilecore"@@master" "pi-mobile-fx::"$pimobilefx"@@master" "pi-rail-base::"$pirailbase"@@master" "pi-rail-client::"$pirailclient"@@master" "pi-rail-fx::"$pirailfx"@@master" "z21-drive::"$Z21Drive"@@master" "FxDock::"$FxDock"@@master" "pi-rail-arduino::"$pirailarduino"@@master" "pi-rail-doc::"$piraildoc"@@master")

for dir in "${repolist[@]}";
do
    echo "=============================================================================="
    repoName="${dir%%::*}"
    _repoUrl="${dir%%@@*}"
    url="${_repoUrl##*::}"
    branchName="${dir##*@@}"
    targetdir="."
    
    echo "$repoName - $url - $branchName => $targetdir/$repoName"

    if [ -d "$repoName" ]
    then
        if [ "$(ls -A $repoName)" ]; then
            echo "Take action $repoName is not Empty"
            cd $(echo $repoName)
            git checkout $branchName
            git branch --list
            git pull
        else
            echo "$dir is Empty"
        fi
    else
       echo "######## STARTED CLONING $repoName ########"
       git clone -b $branchName $url $targetdir/$repoName
    fi
done

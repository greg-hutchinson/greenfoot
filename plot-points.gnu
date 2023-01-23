set terminal gif animate delay 100
set output 'animation.gif'
set xrange [0:10]
set yrange [10:0]
set grid
#set style line 1 lc rgb 'green' pt 7   # circle
#set style line 1 circles linecolor rgb 'green' fill solid noborder
plot "<echo '1 1'" title 'x=1, y=1' with circles linecolor rgb 'green' fill solid noborder
plot "<echo '2 2'"  title 'x=2, y=2' with circles linecolor rgb 'green' fill solid noborder
plot "<echo '3 3'"  title 'x=3, y=3' with circles linecolor rgb 'green' fill solid noborder
plot "<echo '4 4'"  title 'x=4, y=4' with circles linecolor rgb 'green' fill solid noborder
plot "<echo '5 5'"  title 'x=5, y=5' with circles linecolor rgb 'green' fill solid noborder
plot "<echo '6 6'"  title 'x=6, y=6' with circles linecolor rgb 'green' fill solid noborder
plot "<echo '7 7'"  title 'x=7, y=7' with circles linecolor rgb 'green' fill solid noborder
plot '-' title 'x=8, y=8' with circles linecolor rgb 'green' fill solid noborder
8 8
e

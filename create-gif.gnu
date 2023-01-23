set terminal gif animate delay 100
set output 'animation.gif'
stats 'datafile' nooutput
set xrange [0:10]
set yrange [10:0]
set grid

f(x) = x
#do for [i=1:int(STATS_blocks)] {
   plot 'datafile' index (0) title 'x=2, y=2' with circles linecolor rgb "#9ACD32" fill solid noborder 
   plot 'datafile' index (1) title 'x=3, y=3' with circles linecolor rgb "#9ACD32" fill solid noborder 
   plot 'datafile' index (2) title 'x=4, y=4' with circles linecolor rgb "#9ACD32" fill solid noborder 
   plot 'datafile' index (3) title 'x=5, y=5' with circles linecolor rgb "#9ACD32" fill solid noborder 
   plot 'datafile' index (4) title 'x=6, y=6' with circles linecolor rgb "#9ACD32" fill solid noborder 
   plot 'datafile' index (5) title 'x=7, y=7' with circles linecolor rgb "#9ACD32" fill solid noborder 
#    plot 1,2,3 title 'Animation' with circles linecolor rgb "#9ACD32" fill solid noborder 
#}


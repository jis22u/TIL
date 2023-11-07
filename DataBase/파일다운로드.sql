SELECT FL_PTH, CONCAT(SUBSTR(fl_pth, 1,16) ,'\\', SUBSTRING_INDEX( FL_PTH, '\\', -2 ))
from TB_PRPSL_FL;





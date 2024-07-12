-- 코드를 작성해주세요

select count(*) as FISH_COUNT
from fish_info as f join fish_name_info as n
on f.fish_type = n.fish_type
where fish_name in ('BASS', 'SNAPPER')
;
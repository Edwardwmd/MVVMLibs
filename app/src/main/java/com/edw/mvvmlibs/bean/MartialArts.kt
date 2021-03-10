package com.edw.mvvmlibs.bean

/**
 * Author: EdwardWMD
 * Data: 2021/3/10
 * Project: MVVMLibs
 * Website: https://github.com/Edwardwmd
 * Desc: File Information!
 */
data class MartialArts(
    var name: String,
    val age: Int,
    val gender: String,
    val skill: String,
    val strengthOfForce: String
)

private val martialArtsList = mutableListOf(
    MartialArts("张无忌", 22, "男", "乾坤大挪移", "非常强"),
    MartialArts("金毛狮王", 58, "男", "狮吼功", "强"),
    MartialArts("赵敏", 22, "女", "耍阴招", "弱"),
    MartialArts("张三丰", 132, "男", "太极拳", "超级强"),
    MartialArts("扫地僧", 95, "男", "少林绝学", "超级强"),
    MartialArts("周芷若", 22, "女", "九阴白骨爪", "强"),
    MartialArts("乔峰", 40, "男", "降龙十八掌", "非常强"),
    MartialArts("虚竹", 28, "男", "小无相功", "非常强"),
    MartialArts("段誉", 26, "男", "凌波微步", "非常强"),
    MartialArts("天山童姥", 96, "女", "天山折梅手", "超级强"),
    MartialArts("无崖子", 85, "男", "北冥神功", "超级强"),
)

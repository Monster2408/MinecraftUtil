package xyz.mlserver.mc.util.version;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public enum MCVersion {

    /*
        参考サイト
        https://minecraft.fandom.com/wiki/Protocol_version#Java_Edition

        ダミーバージョン例
        v1_18_2(-1, -1, "1.18.2", VersionType.DUMMY)
    */
    v1_19_2    (760,        3120,            "v1_19_2",        VersionType.RELEASE),
    v1_19_2_RC2(0x40000067, 3119, v1_19_2, "v1_19_2_rc2",      VersionType.RELEASE_CANDIDATE),
    v1_19_2_RC1(0x40000066, 3118, v1_19_2, "v1_19_2_rc1",      VersionType.RELEASE_CANDIDATE),

    v1_19_1        (760,        3117,            "v1_19_1",        VersionType.RELEASE),
    v1_19_1_RC3    (0x40000065, 3116, v1_19_1, "v1_19_1_rc3",      VersionType.RELEASE_CANDIDATE),
    v1_19_1_RC2    (0x40000064, 3115, v1_19_1, "v1_19_1_rc2",      VersionType.RELEASE_CANDIDATE),
    v1_19_1_PRE6   (0x40000063, 3114, v1_19_1, "v1_19_1_pre6",     VersionType.PRERELEASE),
    v1_19_1_PRE5   (0x40000062, 3113, v1_19_1, "v1_19_1_pre5",     VersionType.PRERELEASE),
    v1_19_1_PRE4   (0x40000061, 3112, v1_19_1, "v1_19_1_pre4",     VersionType.PRERELEASE),
    v1_19_1_PRE3   (0x40000060, 3111, v1_19_1, "v1_19_1_pre3",     VersionType.PRERELEASE),
    v1_19_1_PRE2   (0x4000005F, 3110, v1_19_1, "v1_19_1_pre2",     VersionType.PRERELEASE),
    v1_19_1_RC1    (0x4000005E, 3109, v1_19_1, "v1_19_1_rc1",      VersionType.RELEASE_CANDIDATE),
    v1_19_1_PRE1   (0x4000005D, 3107, v1_19_1, "v1_19_1_pre1",   VersionType.PRERELEASE),
    SNAPSHOT_22W24A(0x4000005C, 3106, v1_19_1, "snapshot_22w24a",VersionType.SNAPSHOT),

    v1_19                        (759       , 3105,        "v1_19",                        VersionType.RELEASE),
    v1_19_RC2                    (0x4000005B, 3104, v1_19, "v1_19_rc2",                    VersionType.RELEASE_CANDIDATE),
    v1_19_RC1                    (0x4000005A, 3103, v1_19, "v1_19_rc1",                    VersionType.RELEASE_CANDIDATE),
    v1_19_PRE5                   (0x40000059, 3102, v1_19, "v1_19_pre5",                   VersionType.PRERELEASE),
    v1_19_PRE4                   (0x40000058, 3101, v1_19, "v1_19_pre4",                   VersionType.PRERELEASE),
    v1_19_PRE3                   (0x40000057, 3100, v1_19, "v1_19_pre3",                   VersionType.PRERELEASE),
    v1_19_PRE2                   (0x40000056, 3099, v1_19, "v1_19_pre2",                   VersionType.PRERELEASE),
    v1_19_PRE1                   (0x40000055, 3098, v1_19, "v1_19_pre1",                   VersionType.PRERELEASE),
    SNAPSHOT_22W19A              (0x40000054, 3096, v1_19, "snapshot_22w19a",              VersionType.SNAPSHOT),
    SNAPSHOT_22W18A              (0x40000053, 3095, v1_19, "snapshot_22w18a",              VersionType.SNAPSHOT),
    SNAPSHOT_22W17A              (0x40000052, 3093, v1_19, "snapshot_22w17a",              VersionType.SNAPSHOT),
    SNAPSHOT_22W16B              (0x40000051, 3092, v1_19, "snapshot_22w16b",              VersionType.SNAPSHOT),
    SNAPSHOT_22W16A              (0x40000050, 3091, v1_19, "snapshot_22w16a",              VersionType.SNAPSHOT),
    SNAPSHOT_22W15A              (0x4000004F, 3089, v1_19, "snapshot_22w15a",              VersionType.SNAPSHOT),
    SNAPSHOT_22W14A              (0x4000004E, 3088, v1_19, "snapshot_22w14a",              VersionType.SNAPSHOT),
    SNAPSHOT_22W13A              (0x4000004C, 3085, v1_19, "snapshot_22w13a",              VersionType.SNAPSHOT),
    SNAPSHOT_22W12A              (0x4000004B, 3082, v1_19, "snapshot_22w12a",              VersionType.SNAPSHOT),
    SNAPSHOT_22W11A              (0x4000004A, 3080, v1_19, "snapshot_22w11a",              VersionType.SNAPSHOT),
    v1_19_EXPERIMENTAL_SNAPSHOT_1(0x40000045, 3066, v1_19, "1.19_experimental-snapshot-1", VersionType.EXPERIMENTAL_SNAPSHOT),

    v1_18_2        (758, 2975, "1.18.2", VersionType.RELEASE),
    v1_18_2_RC1 (0x40000049,2874,v1_18_2,"1.18.2-rc1",  VersionType.RELEASE_CANDIDATE),
    v1_18_2_PRE3(0x40000048, 2973,v1_18_2, "1.18.2-pre3", VersionType.PRERELEASE),
    v1_18_2_PRE2(0x40000047, 2972,v1_18_2, "1.18.2-pre2", VersionType.PRERELEASE),
    v1_18_2_PRE1(0x40000046, 2971,v1_18_2, "1.18.2-pre1", VersionType.PRERELEASE),
    SNAPSHOT_22W07A(0x40000044, 2969,v1_18_2, "snapshot_22w07a", VersionType.SNAPSHOT),
    SNAPSHOT_22W06A(0x40000043, 2968,v1_18_2, "snapshot_22w06a", VersionType.SNAPSHOT),
    SNAPSHOT_22W05A(0x40000042, 2967,v1_18_2, "snapshot_22w05a", VersionType.SNAPSHOT),
    SNAPSHOT_22W03A(0x40000041, 2966,v1_18_2, "snapshot_22w03a", VersionType.SNAPSHOT),

    v1_18_1     (757,       2865,        "1.18.1",      VersionType.RELEASE),
    v1_18_1_RC3 (0x40000040,2864,v1_18_1,"1.18.1-rc3",  VersionType.RELEASE_CANDIDATE),
    v1_18_1_RC2 (0x4000003F,2863,v1_18_1,"1.18.1-rc2",  VersionType.RELEASE_CANDIDATE),
    v1_18_1_RC1 (0x4000003E,2862,v1_18_1,"1.18.1-rc1",  VersionType.RELEASE_CANDIDATE),
    v1_18_1_PRE1(0x4000003D,2861,v1_18_1,"1.18.1-pre1", VersionType.PRERELEASE),

    v1_18                        (757       ,2860,      "1.18",      VersionType.RELEASE),
    v1_18_RC4                    (0x4000003C,2859,v1_18,"1.18-rc4",  VersionType.RELEASE_CANDIDATE),
    v1_18_RC3                    (0x4000003B,2858,v1_18,"1.18-rc3",  VersionType.RELEASE_CANDIDATE),
    v1_18_RC2                    (0x4000003A,2857,v1_18,"1.18-rc2",  VersionType.RELEASE_CANDIDATE),
    v1_18_RC1                    (0x40000039,2856,v1_18,"1.18-rc1",  VersionType.RELEASE_CANDIDATE),
    v1_18_PRE8                   (0x40000038,2855,v1_18,"1.18-pre8", VersionType.PRERELEASE),
    v1_18_PRE7                   (0x40000037,2854,v1_18,"1.18-pre7", VersionType.PRERELEASE),
    v1_18_PRE6                   (0x40000036,2853,v1_18,"1.18-pre6", VersionType.PRERELEASE),
    v1_18_PRE5                   (0x40000035,2851,v1_18,"1.18-pre5", VersionType.PRERELEASE),
    v1_18_PRE4                   (0x40000034,2850,v1_18,"1.18-pre4", VersionType.PRERELEASE),
    v1_18_PRE3                   (0x40000033,2849,v1_18,"1.18-pre3", VersionType.PRERELEASE),
    v1_18_PRE2                   (0x40000032,2848,v1_18,"1.18-pre2", VersionType.PRERELEASE),
    v1_18_PRE1                   (0x40000031,2847,v1_18,"1.18-pre1", VersionType.PRERELEASE),
    SNAPSHOT_21W44A              (0x40000030, 2845, v1_18,"snapshot_21w44a", VersionType.SNAPSHOT),
    SNAPSHOT_21W43A              (0x4000002F, 2844, v1_18,"snapshot_21w43a", VersionType.SNAPSHOT),
    SNAPSHOT_21W42A              (0x4000002E, 2840, v1_18,"snapshot_21w42a", VersionType.SNAPSHOT),
    SNAPSHOT_21W41A              (0x4000002D, 2839, v1_18,"snapshot_21w41a", VersionType.SNAPSHOT),
    SNAPSHOT_21W40A              (0x4000002C, 2838, v1_18,"snapshot_21w40a", VersionType.SNAPSHOT),
    SNAPSHOT_21W39A              (0x4000002B, 2836, v1_18,"snapshot_21w39a", VersionType.SNAPSHOT),
    SNAPSHOT_21W38A              (0x4000002A, 2835, v1_18,"snapshot_21w38a", VersionType.SNAPSHOT),
    SNAPSHOT_21W37A              (0x40000029, 2834, v1_18,"snapshot_21w37a", VersionType.SNAPSHOT),
    v1_18_EXPERIMENTAL_SNAPSHOT_7(0x4000002F, 2831, v1_18,"1.18_experimental-snapshot-7", VersionType.EXPERIMENTAL_SNAPSHOT),
    v1_18_EXPERIMENTAL_SNAPSHOT_6(0x4000002E, 2830, v1_18,"1.18_experimental-snapshot-6", VersionType.EXPERIMENTAL_SNAPSHOT),
    v1_18_EXPERIMENTAL_SNAPSHOT_5(0x4000002D, 2829, v1_18,"1.18_experimental-snapshot-5", VersionType.EXPERIMENTAL_SNAPSHOT),
    v1_18_EXPERIMENTAL_SNAPSHOT_4(0x4000002C, 2828, v1_18,"1.18_experimental-snapshot-4", VersionType.EXPERIMENTAL_SNAPSHOT),
    v1_18_EXPERIMENTAL_SNAPSHOT_3(0x4000002B, 2827, v1_18,"1.18_experimental-snapshot-3", VersionType.EXPERIMENTAL_SNAPSHOT),
    v1_18_EXPERIMENTAL_SNAPSHOT_2(0x4000002A, 2826, v1_18,"1.18_experimental-snapshot-2", VersionType.EXPERIMENTAL_SNAPSHOT),
    v1_18_EXPERIMENTAL_SNAPSHOT_1(0x40000029, 2825, v1_18,"1.18_experimental-snapshot-1", VersionType.EXPERIMENTAL_SNAPSHOT),

    v1_17_1     (756,        2730,         "1.17.1"),
    v1_17_1_RC2 (0x40000028, 2729, v1_17_1,"1.17.1-rc2"),
    v1_17_1_RC1 (0x40000027, 2728, v1_17_1,"1.17.1-rc1"),
    v1_17_1_PRE3(0x40000026, 2727, v1_17_1,"1.17.1-pre3"),
    v1_17_1_PRE2(0x40000025, 2726, v1_17_1,"1.17.1-pre2"),
    v1_17_1_PRE1(0x40000024, 2725, v1_17_1,"1.17.1-pre1"),

    v1_17          (755,        2724,        "1.17"), // unreleased
    v1_17_RC2      (0x40000023, 2723, v1_17, "1.17-rc2"),
    v1_17_RC1      (0x40000022, 2722, v1_17, "1.17-rc1"),
    v1_17_PRE5     (0x40000021, 2721, v1_17, "1.17-pre5"),
    v1_17_PRE4     (0x40000020, 2720, v1_17, "1.17-pre4"),
    v1_17_PRE3     (0x4000001F, 2719, v1_17, "1.17-pre3"),
    v1_17_PRE2     (0x4000001E, 2718, v1_17, "1.17-pre2"),
    v1_17_PRE1     (0x4000001D, 2716, v1_17, "1.17-pre1"),
    SNAPSHOT_21W20A(0x4000001C, 2715, v1_17, "snapshot_21w20a"),
    SNAPSHOT_21W19A(0x4000001B, 2714, v1_17, "snapshot_21w19a"),
    SNAPSHOT_21W18A(0x4000001A, 2713, v1_17, "snapshot_21w18a"),
    SNAPSHOT_21W17A(0x40000019, 2712, v1_17, "snapshot_21w17a"),
    SNAPSHOT_21W16A(0x40000017, 2711, v1_17, "snapshot_21w16a"),
    SNAPSHOT_21W15A(0x40000016, 2709, v1_17, "snapshot_21w15a"),
    SNAPSHOT_21W14A(0x40000015, 2706, v1_17, "snapshot_21w14a"),
    SNAPSHOT_21W13A(0x40000014, 2705, v1_17, "snapshot_21w13a"),
    SNAPSHOT_21W11A(0x40000013, 2703, v1_17, "snapshot_21w11a"),
    SNAPSHOT_21W10A(0x40000012, 2699, v1_17, "snapshot_21w10a"),
    SNAPSHOT_21W08B(0x40000011, 2698, v1_17, "snapshot_21w08b"),
    SNAPSHOT_21W08A(0x40000010, 2697, v1_17, "snapshot_21w08a"),
    SNAPSHOT_21W07A(0x4000000F, 2695, v1_17, "snapshot_21w07a"),
    SNAPSHOT_21W06A(0x4000000E, 2694, v1_17, "snapshot_21w06a"),
    SNAPSHOT_21W05B(0x4000000D, 2692, v1_17, "snapshot_21w05b"),
    SNAPSHOT_21W05A(0x4000000C, 2690, v1_17, "snapshot_21w05a"),
    SNAPSHOT_21W03A(0x4000000B, 2689, v1_17, "snapshot_21w03a"),
    SNAPSHOT_20W51A(0x40000009, 2687, v1_17, "snapshot_20w51a"),
    SNAPSHOT_20W49A(0x40000008, 2685, v1_17, "snapshot_20w49a"),
    SNAPSHOT_20W48A(0x40000007, 2683, v1_17, "snapshot_20w48a"),
    SNAPSHOT_20W46A(0x40000006, 2682, v1_17, "snapshot_20w46a"),
    SNAPSHOT_20W45A(0x40000005, 2681, v1_17, "snapshot_20w45a"),

    v1_16_5    (754, 2586, "1.16.5"),
    v1_16_5_RC1(0x4000000A, 2585, v1_16_5, "1.16.5-rc1"),

    v1_16_4     (754,        2584, "1.16.4"),
    v1_16_4_RC1 (0x40000003, 2583, "1.16.4-rc1"),
    v1_16_4_PRE2(0x40000002, 2582, "1.16.4-pre2"),
    v1_16_4_PRE1(0x40000001, 2581, "1.16.4-pre1"), // New network protocol scheme, with a high bit (bit 30) set for snapshots.

    v1_16_3    (753, 2580,          "1.16.3"),
    v1_16_3_RC1(752, 2579, v1_16_3, "1.16.3-rc1"),

    v1_16_2        (751, 2578,          "1.16.2"),
    v1_16_2_RC2    (750, 2577, v1_16_2, "1.16.2-rc2"),
    v1_16_2_RC1    (749, 2576, v1_16_2, "1.16.2-rc1"),
    v1_16_2_PRE3   (748, 2575, v1_16_2, "1.16.2-pre3"),
    v1_16_2_PRE2   (746, 2574, v1_16_2, "1.16.2-pre2"),
    v1_16_2_PRE1   (744, 2573, v1_16_2, "1.16.2-pre1"),
    SNAPSHOT_20W30A(742, 2572, v1_16_2, "snapshot_20w30a"),
    SNAPSHOT_20W29A(741, 2571, v1_16_2, "snapshot_20w29a"),
    SNAPSHOT_20W28A(740, 2570, v1_16_2, "snapshot_20w28a"),
    SNAPSHOT_20W27A(738, 2569, v1_16_2, "snapshot_20w27a"),

    v1_16_1(736, 2567, "1.16.1"),

    v1_16          (735, 2566, "1.16"),
    v1_16_RC1      (734, 2565, v1_16, "1.16-rc1"),
    v1_16_PRE8     (733, 2564, v1_16, "1.16-pre8"),
    v1_16_PRE7     (732, 2563, v1_16, "1.16-pre7"),
    v1_16_PRE6     (730, 2562, v1_16, "1.16-pre6"),
    v1_16_PRE5     (729, 2561, v1_16, "1.16-pre5"),
    v1_16_PRE4     (727, 2560, v1_16, "1.16-pre4"),
    v1_16_PRE3     (725, 2559, v1_16, "1.16-pre3"),
    v1_16_PRE2     (722, 2557, v1_16, "1.16-pre2"),
    v1_16_PRE1     (721, 2556, v1_16, "1.16-pre1"),
    SNAPSHOT_20W22A(719, 2555, v1_16, "snapshot_20w22a"),
    SNAPSHOT_20W21A(718, 2554, v1_16, "snapshot_20w21a"),
    SNAPSHOT_20W20B(717, 2537, v1_16, "snapshot_20w20b"),
    SNAPSHOT_20W20A(716, 2536, v1_16, "snapshot_20w20a"),
    SNAPSHOT_20W19A(715, 2534, v1_16, "snapshot_20w19a"),
    SNAPSHOT_20W18A(714, 2532, v1_16, "snapshot_20w18a"),
    SNAPSHOT_20W17A(713, 2529, v1_16, "snapshot_20w17a"),
    SNAPSHOT_20W16A(712, 2526, v1_16, "snapshot_20w16a"),
    SNAPSHOT_20W15A(711, 2525, v1_16, "snapshot_20w15a"),
    SNAPSHOT_20W14A(710, 2524, v1_16, "snapshot_20w14a"),
    SNAPSHOT_20W14 (709, 2522, v1_16, "snapshot_20w14∞", VersionType.APRIL_FOOLS), // april fool
    SNAPSHOT_20W13B(709, 2521, v1_16, "snapshot_20w13b"),
    SNAPSHOT_20W13A(708, 2520, v1_16, "snapshot_20w13a"),
    SNAPSHOT_20W12A(707, 2515, v1_16, "snapshot_20w12a"),
    SNAPSHOT_20W11A(706, 2513, v1_16, "snapshot_20w11a"),
    SNAPSHOT_20W10A(705, 2512, v1_16, "snapshot_20w10a"),
    SNAPSHOT_20W09A(704, 2510, v1_16, "snapshot_20w09a"),
    SNAPSHOT_20W08A(703, 2507, v1_16, "snapshot_20w08a"),
    SNAPSHOT_20W07A(702, 2506, v1_16, "snapshot_20w07a"),
    SNAPSHOT_20W06A(701, 2504, v1_16, "snapshot_20w06a"),

    v1_15_2(578, 2230, "1.15.2"),
    v1_15_2_PRE2(577, 2229, v1_15_2, "1.15.2-pre2"),
    v1_15_2_PRE1(576, 2228, v1_15_2, "1.15.2-pre1"),
    v1_15_1(575, 2227, "1.15.1"),
    v1_15_1_PRE1(574, 2226, v1_15_1, "1.15.1-pre1"),
    v1_15(573, 2225, "1.15"),
    v1_15_PRE7(572, 2224, v1_15, "1.15-pre7"),
    v1_15_PRE6(571, 2223, v1_15, "1.15-pre6"),
    v1_15_PRE5(570, 2222, v1_15, "1.15-pre5"),
    v1_15_PRE4(569, 2221, v1_15, "1.15-pre4"),
    v1_15_PRE3(567, 2220, v1_15, "1.15-pre3"),
    v1_15_PRE2(566, 2219, v1_15, "1.15-pre2"),
    v1_15_PRE1(565, 2218, v1_15, "1.15-pre1"),
    SNAPSHOT_19W46B(564, 2217, v1_15, "snapshot_19w46b"),
    SNAPSHOT_19W46A(563, 2216, v1_15, "snapshot_19w46a"),
    SNAPSHOT_19W45B(562, 2215, v1_15, "snapshot_19w45b"),
    SNAPSHOT_19W45A(561, 2214, v1_15, "snapshot_19w45a"),
    SNAPSHOT_19W44A(560, 2213, v1_15, "snapshot_19w44a"),
    SNAPSHOT_19W42A(559, 2212, v1_15, "snapshot_19w42a"),
    SNAPSHOT_19W41A(558, 2210, v1_15, "snapshot_19w41a"),
    SNAPSHOT_19W40A(557, 2208, v1_15, "snapshot_19w40a"),
    SNAPSHOT_19W39A(556, 2207, v1_15, "snapshot_19w39a"),
    SNAPSHOT_19W38B(555, 2206, v1_15, "snapshot_19w38b"),
    SNAPSHOT_19W38A(554, 2205, v1_15, "snapshot_19w18a"),
    SNAPSHOT_19W37A(553, 2204, v1_15, "snapshot_19w37a"),
    SNAPSHOT_19W36A(552, 2203, v1_15, "snapshot_19w36a"),
    SNAPSHOT_19W35A(551, 2201, v1_15, "snapshot_19w35a"),
    SNAPSHOT_19W34A(550, 2200, v1_15, "snapshot_19w34a"),

    v1_14_4(498, 1976, "1.14.4"),
    v1_14_4_PRE7(497, 1975, v1_14_4, "1.14.4-pre7"),
    v1_14_4_PRE6(496, 1974, v1_14_4, "1.14.4-pre6"),
    v1_14_4_PRE5(495, 1973, v1_14_4, "1.14.4-pre5"),
    v1_14_4_PRE4(494, 1972, v1_14_4, "1.14.4-pre4"),
    v1_14_4_PRE3(493, 1971, v1_14_4, "1.14.4-pre3"),
    v1_14_4_PRE2(492, 1970, v1_14_4, "1.14.4-pre2"),
    v1_14_4_PRE1(491, 1969, v1_14_4, "1.14.4-pre1"),
    v1_14_3(490, 1968, "1.14.3"),
    v1_14_3_PRE4(489, 1967, v1_14_3, "1.14.3-pre4"),
    v1_14_3_PRE3(488, 1966, v1_14_3, "1.14.3-pre3"),
    v1_14_3_PRE2(487, 1965, v1_14_3, "1.14.3-pre2"),
    v1_14_3_PRE1(486, 1964, v1_14_3, "1.14.3-pre1"),
    v1_14_2(485, 1963, "1.14.2"),
    v1_14_2_PRE4(484, 1962, v1_14_2, "1.14.2-pre4"),
    v1_14_2_PRE3(483, 1960, v1_14_2, "1.14.2-pre3"),
    v1_14_2_PRE2(482, 1959, v1_14_2, "1.14.2-pre2"),
    v1_14_2_PRE1(481, 1958, v1_14_2, "1.14.2-pre1"),
    v1_14_1(480, 1957, "1.14.1"),
    v1_14_1_PRE2(479, 1956, v1_14_1, "1.14.1-pre2"),
    v1_14_1_PRE1(478, 1955, v1_14_1, "1.14.1-pre1"),
    v1_14(477, 1952, "1.14"),
    v1_14_PRE5(476, 1951, v1_14, "1.14-pre5"),
    v1_14_PRE4(475, 1950, v1_14, "1.14-pre4"),
    v1_14_PRE3(474, 1949, v1_14, "1.14-pre3"),
    v1_14_PRE2(473, 1948, v1_14, "1.14-pre2"),
    v1_14_PRE1(472, 1947, v1_14, "1.14-pre1"),
    SNAPSHOT_19W14B(471, 1945, v1_14, "snapshot_19w14b"),
    SNAPSHOT_19W14A(470, 1944, v1_14, "snapshot_19w14a"),

    MC_3D_SHAREWARE_v1_34(1, 1943, v1_14, "3D Shareware v1.34", VersionType.APRIL_FOOLS), // april fools
    SNAPSHOT_19W13B(469, 1943, v1_14, "snapshot_19w13b"),
    SNAPSHOT_19W13A(468, 1942, v1_14, "snapshot_19w13a"),
    SNAPSHOT_19W12B(467, 1941, v1_14, "snapshot_19w12b"),
    SNAPSHOT_19W12A(466, 1940, v1_14, "snapshot_19w12a"),
    SNAPSHOT_19W11B(465, 1938, v1_14, "snapshot_19w11b"),
    SNAPSHOT_19W11A(464, 1937, v1_14, "snapshot_19w11a"),
    SNAPSHOT_19W09A(463, 1935, v1_14, "snapshot_19w09a"),
    SNAPSHOT_19W08B(462, 1934, v1_14, "snapshot_19w08b"),
    SNAPSHOT_19W08A(461, 1933, v1_14, "snapshot_19w08a"),
    SNAPSHOT_19W07A(460, 1932, v1_14, "snapshot_19w07a"),
    SNAPSHOT_19W06A(459, 1931, v1_14, "snapshot_19w06a"),
    SNAPSHOT_19W05A(458, 1930, v1_14, "snapshot_19w05a"),
    SNAPSHOT_19W04B(457, 1927, v1_14, "snapshot_19w04b"),
    SNAPSHOT_19W04A(456, 1926, v1_14, "snapshot_19w04a"),
    SNAPSHOT_19W03C(455, 1924, v1_14, "snapshot_19w03c"),
    SNAPSHOT_19W03B(454, 1923, v1_14, "snapshot_19w03b"),
    SNAPSHOT_19W03A(453, 1922, v1_14, "snapshot_19w03a"),
    SNAPSHOT_19W02A(452, 1921, v1_14, "snapshot_19w02a"),
    SNAPSHOT_18W50A(451, 1919, v1_14, "snapshot_18w50a"),
    SNAPSHOT_18W49A(450, 1916, v1_14, "snapshot_18w49a"),
    SNAPSHOT_18W48B(449, 1915, v1_14, "snapshot_18w48b"),
    SNAPSHOT_18W48A(448, 1914, v1_14, "snapshot_18w48a"),
    SNAPSHOT_18W47B(447, 1913, v1_14, "snapshot_18w47b"),
    SNAPSHOT_18W47A(446, 1912, v1_14, "snapshot_18w47a"),
    SNAPSHOT_18W46A(445, 1910, v1_14, "snapshot_18w46a"),
    SNAPSHOT_18W45A(444, 1908, v1_14, "snapshot_18w45a"),
    SNAPSHOT_18W44A(443, 1907, v1_14, "snapshot_18w44a"),
    SNAPSHOT_18W43C(442, 1903, v1_14, "snapshot_18w43c"),
    SNAPSHOT_18W43B(441, 1902, v1_14, "snapshot_18w43b"),
    SNAPSHOT_18W43A(440, 1901, v1_14, "snapshot_18w43a"),

    v1_13_2(404, 1631, "1.13.2"),
    v1_13_2_PRE2(403, 1630, v1_13_2, "1.13.2-pre2"),
    v1_13_2_PRE1(402, 1629, v1_13_2, "1.13.2-pre1"),
    v1_13_1(401, 1628, "1.13.1"),
    v1_13_1_PRE2(400, 1627, v1_13_1, "1.13.1-pre2"),
    v1_13_1_PRE1(399, 1626, v1_13_1, "1.13.1-pre1"),
    SNAPSHOT_18W33A(398, 1625, v1_13_1, "snapshot_18w33a"),
    SNAPSHOT_18W32A(397, 1623, v1_13_1, "snapshot_18w32a"),
    SNAPSHOT_18W31A(396, 1622, v1_13_1, "snapshot_18w31a"),
    SNAPSHOT_18W30B(395, 1621, v1_13_1, "snapshot_18w30b"),
    SNAPSHOT_18W30A(394, 1620, v1_13_1, "snapshot_18w30a"),
    v1_13(393, 1519, "1.13"),
    v1_13_PRE10(392, 1518, v1_13, "1.13-pre10"),
    v1_13_PRE9(391, 1517, v1_13, "1.13-pre9"),
    v1_13_PRE8(390, 1516, v1_13, "1.13-pre8"),
    v1_13_PRE7(389, 1513, v1_13, "1.13-pre7"),
    v1_13_PRE6(388, 1512, v1_13, "1.13-pre6"),
    v1_13_PRE5(387, 1511, v1_13, "1.13-pre5"),
    v1_13_PRE4(386, 1504, v1_13, "1.13-pre4"),
    v1_13_PRE3(385, 1503, v1_13, "1.13-pre3"),
    v1_13_PRE2(384, 1502, v1_13, "1.13-pre2"),
    v1_13_PRE1(383, 1501, v1_13, "1.13-pre1"),
    SNAPSHOT_18W22C(382, 1499, v1_13, "snapshot_18w22c"),
    SNAPSHOT_18W22B(381, 1498, v1_13, "snapshot_18w22b"),
    SNAPSHOT_18W22A(380, 1497, v1_13, "snapshot_18w22a"),
    SNAPSHOT_18W21B(379, 1496, v1_13, "snapshot_18w21b"),
    SNAPSHOT_18W21A(379, 1495, v1_13, "snapshot_18w21a"),
    SNAPSHOT_18W20C(377, 1493, v1_13, "snapshot_18w20c"),
    SNAPSHOT_18W20B(376, 1491, v1_13, "snapshot_18w20b"),
    SNAPSHOT_18W20A(375, 1489, v1_13, "snapshot_18w20a"),
    SNAPSHOT_18W19B(374, 1485, v1_13, "snapshot_18w19b"),
    SNAPSHOT_18W19A(373, 1484, v1_13, "snapshot_18w19a"),
    SNAPSHOT_18W16A(372, 1483, v1_13, "snapshot_18w16a"),
    SNAPSHOT_18W15A(371, 1482, v1_13, "snapshot_18w15a"),
    SNAPSHOT_18W14B(370, 1481, v1_13, "snapshot_18w14b"),
    SNAPSHOT_18W14A(369, 1479, v1_13, "snapshot_18w14a"),
    SNAPSHOT_18W11A(368, 1478, v1_13, "snapshot_18w11a"),
    SNAPSHOT_18W10D(367, 1477, v1_13, "snapshot_18w10d"),
    SNAPSHOT_18W10C(366, 1476, v1_13, "snapshot_18w10c"),
    SNAPSHOT_18W10B(365, 1474, v1_13, "snapshot_18w10b"),
    SNAPSHOT_18W10A(364, 1473, v1_13, "snapshot_18w10a"),
    SNAPSHOT_18W09A(363, 1472, v1_13, "snapshot_18w09a"),
    SNAPSHOT_18W08B(362, 1471, v1_13, "snapshot_18w08b"),
    SNAPSHOT_18W08A(361, 1470, v1_13, "snapshot_18w08a"),
    SNAPSHOT_18W07C(360, 1469, v1_13, "snapshot_18w07c"),
    SNAPSHOT_18W07B(359, 1468, v1_13, "snapshot_18w07b"),
    SNAPSHOT_18W07A(358, 1467, v1_13, "snapshot_18w07a"),
    SNAPSHOT_18W06A(357, 1466, v1_13, "snapshot_18w06a"),
    SNAPSHOT_18W05A(356, 1464, v1_13, "snapshot_18w05a"),
    SNAPSHOT_18W03B(355, 1463, v1_13, "snapshot_18w03b"),
    SNAPSHOT_18W03A(354, 1462, v1_13, "snapshot_18w03a"),
    SNAPSHOT_18W02A(353, 1461, v1_13, "snapshot_18w02a"), // flattened entity IDs (https://pokechu22.github.io/Burger/diff_18w01a_18w02a.html#entities)
    SNAPSHOT_18W01A(352, 1459, v1_13, "snapshot_18w01a"),
    SNAPSHOT_17W50A(351, 1457, v1_13, "snapshot_17w50a"),
    SNAPSHOT_17W49B(350, 1455, v1_13, "snapshot_17w49b"),
    SNAPSHOT_17W49A(349, 1454, v1_13, "snapshot_17w49a"),
    SNAPSHOT_17W48A(348, 1453, v1_13, "snapshot_17w48a"),
    SNAPSHOT_17W47B(347, 1452, v1_13, "snapshot_17w47b"),
    SNAPSHOT_17W47A(346, 1451, v1_13, "snapshot_17w47a"), // flattening update!
    SNAPSHOT_17W46A(345, 1449, v1_13, "snapshot_17w46a"),
    SNAPSHOT_17W45B(344, 1448, v1_13, "snapshot_17w45b"),
    SNAPSHOT_17W45A(343, 1447, v1_13, "snapshot_17w45a"),
    SNAPSHOT_17W43B(342, 1445, v1_13, "snapshot_17w43b"),
    SNAPSHOT_17W43A(341, 1444, v1_13, "snapshot_17w43a"),

    v1_12_2(340, 1343, "1.12.2"),
    v1_12_2_PRE2(339, 1342, v1_12_2, "1.12.2-pre2"),
    v1_12_2_PRE1(339, 1341, v1_12_2, "1.12.2-pre1"),
    v1_12_1(338, 1241, "1.12.1"),
    v1_12_1_PRE1(337, 1240, v1_12_1, "1.12.1-pre1"),
    SNAPSHOT_17W31A(336, 1239, v1_12_1, "snapshot_17w31a"),
    v1_12(335, 1139, "1.12"),
    v1_12_PRE7(334, 1138, v1_12, "1.12-pre7"),
    v1_12_PRE6(333, 1137, v1_12, "1.12-pre6"),
    v1_12_PRE5(332, 1136, v1_12, "1.12-pre5"),
    v1_12_PRE4(331, 1135, v1_12, "1.12-pre4"),
    v1_12_PRE3(330, 1134, v1_12, "1.12-pre3"),
    v1_12_PRE2(329, 1133, v1_12, "1.12-pre2"),
    v1_12_PRE1(328, 1132, v1_12, "1.12-pre1"),
    SNAPSHOT_17W18B(327, 1131, v1_12, "snapshot_17w18b"),
    SNAPSHOT_17W18A(326, 1130, v1_12, "snapshot_17w18a"),
    SNAPSHOT_17W17B(325, 1129, v1_12, "snapshot_17w17b"),
    SNAPSHOT_17W17A(324, 1128, v1_12, "snapshot_17w17a"),
    SNAPSHOT_17W16B(323, 1127, v1_12, "snapshot_17w16b"),
    SNAPSHOT_17W16A(322, 1126, v1_12, "snapshot_17w16a"),
    SNAPSHOT_17W15A(321, 1125, v1_12, "snapshot_17w15a"),
    SNAPSHOT_17W14A(320, 1124, v1_12, "snapshot_17w14a"),
    SNAPSHOT_17W13B(319, 1123, v1_12, "snapshot_17w13b"),
    SNAPSHOT_17W13A(318, 1122, v1_12, "snapshot_17w13a"),
    SNAPSHOT_17W06A(317, 1022, v1_12, "snapshot_17w06a"),

    v1_11_2(316, 922, null, "1.11.2"),
    v1_11_1(316, 921, null, "1.11.1"),
    SNAPSHOT_16W50A(316, 920, v1_11_1, "snapshot_16w50a"),
    v1_11(315, 819, null, "1.11"),
    v1_11_PRE1(314, 818, v1_11, "1.11-pre1"),
    SNAPSHOT_16W44A(313, 817, v1_11, "snapshot_16w44a"),
    SNAPSHOT_16W43A(313, 816, v1_11, "snapshot_16w43a"),
    SNAPSHOT_16W42A(312, 815, v1_11, "snapshot_16w42a"),
    SNAPSHOT_16W41A(311, 814, v1_11, "snapshot_16w41a"),
    SNAPSHOT_16W40A(310, 813, v1_11, "snapshot_16w40a"),
    SNAPSHOT_16W39C(309, 812, v1_11, "snapshot_16w39c"),
    SNAPSHOT_16W39B(308, 811, v1_11, "snapshot_16w39b"),
    SNAPSHOT_16W39A(307, 809, v1_11, "snapshot_16w39a"),
    SNAPSHOT_16W38A(306, 807, v1_11, "snapshot_16w38a"),
    SNAPSHOT_16W36A(305, 805, v1_11, "snapshot_16w36a"),
    SNAPSHOT_16W35A(304, 803, v1_11, "snapshot_16w35a"),
    SNAPSHOT_16W33A(303, 803, v1_11, "snapshot_16w33a"),
    SNAPSHOT_16W32B(302, 801, v1_11, "snapshot_16w32b"),
    SNAPSHOT_16W32A(301, 800, v1_11, "snapshot_16w32a"),

    v1_10_2(210, 512, null, "1.10.2"),
    v1_10_1(210, 511, null, "1.10.1"),
    v1_10(210, 510, null, "1.10"),
    v1_10_PRE2(205, 507, v1_10, "1.10-pre2"),
    v1_10_PRE1(204, 506, v1_10, "1.10-pre1"),
    SNAPSHOT_16W21B(203, 504, v1_10, "snapshot_16w21b"),
    SNAPSHOT_16W21A(202, 503, v1_10, "snapshot_16w21a"),
    SNAPSHOT_16W20A(201, 501, v1_10, "snapshot_16w20a"),

    v1_9_4(110, 184, null, "1.9.4"),
    v1_9_3(110, 183, null, "1.9.3"),
    v1_9_3_PRE3(110, 182, v1_9_3, "1.9.3-pre3"),
    v1_9_3_PRE2(110, 181, v1_9_3, "1.9.3-pre2"),
    v1_9_3_PRE1(109, 180, v1_9_3, "1.9.3-pre1"),
    SNAPSHOT_16W15B(109, 179, v1_9_3, "snapshot_16w15b"),
    SNAPSHOT_16W15A(109, 178, v1_9_3, "snapshot_16w15a"),
    SNAPSHOT_16W14A(109, 177, v1_9_3, "snapshot_16w14a"),
    v1_9_2(109, 176, null, "1.9.2"),
    v1_RV_PRE1(108, 173,null, "1.RV-pre1", VersionType.APRIL_FOOLS), // april fool
    v1_9_1(108, 175, null, "1.9.1"),
    v1_9_1_PRE3(108, 172, v1_9_1, "1.9.1-pre3"),
    v1_9_1_PRE2(108, 171, v1_9_1, "1.9.1-pre2"),
    v1_9_1_PRE1(107, 170, v1_9_1, "1.9.1-pre1"),
    v1_9           (107, 169, null, "1.9"),
    v1_9_PRE4      (106, 168, v1_9, "1.9-pre4"),
    v1_9_PRE3      (105, 167, v1_9, "1.9-pre3"),
    v1_9_PRE2      (104, 165, v1_9, "1.9-pre2"),
    v1_9_PRE1      (103, 164, v1_9, "1.9-pre1"),
    SNAPSHOT_16W07B(102, 163, v1_9, "snapshot_16w07b"),
    SNAPSHOT_16W07A(101, 162, v1_9, "snapshot_16w07a"),
    SNAPSHOT_16W06A(100, 161, v1_9, "snapshot_16w06a"),
    SNAPSHOT_16W05B(99,  160, v1_9, "snapshot_16w05b"),
    SNAPSHOT_16W05A(98,  159, v1_9, "snapshot_16w05a"),
    SNAPSHOT_16W04A(97,  158, v1_9, "snapshot_16w04a"),
    SNAPSHOT_16W03A(96,  157, v1_9, "snapshot_16w03a"),
    SNAPSHOT_16W02A(95,  156, v1_9, "snapshot_16w02a"),
    SNAPSHOT_15W51B(94,  155, v1_9, "snapshot_15w51b"),
    SNAPSHOT_15W51A(93,  154, v1_9, "snapshot_15w51a"),
    SNAPSHOT_15W50A(92,  153, v1_9, "snapshot_15w50a"),
    SNAPSHOT_15W49B(91,  152, v1_9, "snapshot_15w49b"),
    SNAPSHOT_15W49A(90,  151, v1_9, "snapshot_15w49a"),
    SNAPSHOT_15W47C(89,  150, v1_9, "snapshot_15w47c"),
    SNAPSHOT_15W47B(88,  149, v1_9, "snapshot_15w47b"),
    SNAPSHOT_15W47A(87,  148, v1_9, "snapshot_15w47a"),
    SNAPSHOT_15W46A(86,  146, v1_9, "snapshot_15w46a"),
    SNAPSHOT_15W45A(85,  145, v1_9, "snapshot_15w45a"),
    SNAPSHOT_15W44B(84,  143, v1_9, "snapshot_15w44b"),
    SNAPSHOT_15W44A(83,  142, v1_9, "snapshot_15w44a"),
    SNAPSHOT_15W43C(82,  141, v1_9, "snapshot_15w43c"),
    SNAPSHOT_15W43B(81,  140, v1_9, "snapshot_15w43b"),
    SNAPSHOT_15W43A(80,  139, v1_9, "snapshot_15w43a"),
    SNAPSHOT_15W42A(79,  138, v1_9, "snapshot_15w42a"),
    SNAPSHOT_15W41B(78,  137, v1_9, "snapshot_15w41b"),
    SNAPSHOT_15W41A(77,  136, v1_9, "snapshot_15w41a"),
    SNAPSHOT_15W40B(76,  134, v1_9, "snapshot_15w40b"),
    SNAPSHOT_15W40A(75,  133, v1_9, "snapshot_15w40a"),
    SNAPSHOT_15W39C(74,  132, v1_9, "snapshot_15w39c"),
    SNAPSHOT_15W39B(74,  131, v1_9, "snapshot_15w39b"),
    SNAPSHOT_15W39A(74,  130, v1_9, "snapshot_15w39a"),
    SNAPSHOT_15W38B(73,  129, v1_9, "snapshot_15w38b"),
    SNAPSHOT_15W38A(72,  128, v1_9, "snapshot_15w38a"),
    SNAPSHOT_15W37A(71,  127, v1_9, "snapshot_15w37a"),
    SNAPSHOT_15W36D(70,  126, v1_9, "snapshot_15w36d"),
    SNAPSHOT_15W36C(69,  125, v1_9, "snapshot_15w36c"),
    SNAPSHOT_15W36B(68,  124, v1_9, "snapshot_15w36b"),
    SNAPSHOT_15W36A(67,  123, v1_9, "snapshot_15w36a"),
    SNAPSHOT_15W35E(66,  122, v1_9, "snapshot_15w35e"),
    SNAPSHOT_15W35D(65,  121, v1_9, "snapshot_15w35d"),
    SNAPSHOT_15W35C(64,  120, v1_9, "snapshot_15w35c"),
    SNAPSHOT_15W35B(63,  119, v1_9, "snapshot_15w35b"),
    SNAPSHOT_15W35A(62,  118, v1_9, "snapshot_15w35a"),
    SNAPSHOT_15W34D(61,  117, v1_9, "snapshot_16w34d"),
    SNAPSHOT_15W34C(60,  116, v1_9, "snapshot_15w34c"),
    SNAPSHOT_15W34B(59,  115, v1_9, "snapshot_15w34b"),
    SNAPSHOT_15W34A(58,  114, v1_9, "snapshot_15w34a"),
    SNAPSHOT_15W33C(57,  112, v1_9, "snapshot_15w33c"),
    SNAPSHOT_15W33B(56,  111, v1_9, "snapshot_15w33b"),
    SNAPSHOT_15W33A(55,  111, v1_9, "snapshot_15w33a"),
    SNAPSHOT_15W32C(54,  104, v1_9, "snapshot_15w32c"),
    SNAPSHOT_15W32B(53,  103, v1_9, "snapshot_15w32b"),
    SNAPSHOT_15W32A(52,  100, v1_9, "snapshot_15w32a"),
    SNAPSHOT_15W31C(51,                 v1_9, "snapshot_15w31c"),
    SNAPSHOT_15W31B(50,                 v1_9, "snapshot_15w31b"),
    SNAPSHOT_15W31A(49,                 v1_9, "snapshot_15w31a"),

    SNAPSHOT_15W14A(48, -1, "snapshot_15w14a", VersionType.APRIL_FOOLS), // april fools

    v1_8_9     (47,         "1.8.9"),
    v1_8_8     (47,         "1.8.8"),
    v1_8_7     (47,         "1.8.7"),
    v1_8_6     (47,         "1.8.6"),
    v1_8_5     (47,         "1.8.5"),
    v1_8_4     (47,         "1.8.4"),
    v1_8_3     (47,         "1.8.3"),
    v1_8_2     (47,         "1.8.2"),
    v1_8_2_PRE7(47, v1_8_2, "1.8.2-pre7"),
    v1_8_2_PRE6(47, v1_8_2, "1.8.2-pre6"),
    v1_8_2_PRE5(47, v1_8_2, "1.8.2-pre5"),
    v1_8_2_PRE4(47, v1_8_2, "1.8.2-pre4"),
    v1_8_2_PRE3(47, v1_8_2, "1.8.2-pre3"),
    v1_8_2_PRE2(47, v1_8_2, "1.8.2-pre2"),
    v1_8_2_PRE1(47, v1_8_2, "1.8.2-pre1"),
    v1_8_1     (47,         "1.8.1"),
    v1_8_1_PRE5(47, v1_8_1, "1.8.1-pre5"),
    v1_8_1_PRE4(47, v1_8_1, "1.8.1-pre4"),
    v1_8_1_PRE3(47, v1_8_1, "1.8.1-pre3"),
    v1_8_1_PRE2(47, v1_8_1, "1.8.1-pre2"),
    v1_8_1_PRE1(47, v1_8_1, "1.8.1-pre1"),

    v1_8           (47,       "1.8"),
    v1_8_PRE3      (46, v1_8, "1.8-pre3"),
    v1_8_PRE2      (45, v1_8, "1.8-pre2"),
    v1_8_PRE1      (44, v1_8, "1.8-pre1"),
    SNAPSHOT_14W34D(43, v1_8, "snapshot_14w34d"),
    SNAPSHOT_14W34C(42, v1_8, "snapshot_14w34c"),
    SNAPSHOT_14W34B(41, v1_8, "snapshot_14w34b"),
    SNAPSHOT_14W34A(40, v1_8, "snapshot_14w34a"),
    SNAPSHOT_14W33C(39, v1_8, "snapshot_14w33c"),
    SNAPSHOT_14W33B(38, v1_8, "snapshot_14w33b"),
    SNAPSHOT_14W33A(37, v1_8, "snapshot_14w33a"),
    SNAPSHOT_14W32D(36, v1_8, "snapshot_14w32d"),
    SNAPSHOT_14W32C(35, v1_8, "snapshot_14w32c"),
    SNAPSHOT_14W32B(34, v1_8, "snapshot_14w32b"),
    SNAPSHOT_14W32A(33, v1_8, "snapshot_14w32a"),
    SNAPSHOT_14W31A(32, v1_8, "snapshot_14w31a"),
    SNAPSHOT_14W30C(31, v1_8, "snapshot_14w30c"),
    SNAPSHOT_14W30B(30, v1_8, "snapshot_14w30b"),
    SNAPSHOT_14W30A(30, v1_8, "snapshot_14w30a"),
    SNAPSHOT_14W29B(29, v1_8, "snapshot_14w29b"),
    SNAPSHOT_14W29A(29, v1_8, "snapshot_14w29a"),
    SNAPSHOT_14W28B(28, v1_8, "snapshot_14w28b"),
    SNAPSHOT_14W28A(27, v1_8, "snapshot_14w28a"),
    SNAPSHOT_14W27B(26, v1_8, "snapshot_14w27b"),
    SNAPSHOT_14W27A(26, v1_8, "snapshot_14w27a"),
    SNAPSHOT_14W26C(25, v1_8, "snapshot_14w26c"),
    SNAPSHOT_14W26B(24, v1_8, "snapshot_14w26b"),
    SNAPSHOT_14W26A(23, v1_8, "snapshot_14w26a"),
    SNAPSHOT_14W25B(22, v1_8, "snapshot_14w25b"),
    SNAPSHOT_14W25A(21, v1_8, "snapshot_14w25a"),
    SNAPSHOT_14W21B(20, v1_8, "snapshot_14w21b"),
    SNAPSHOT_14W21A(19, v1_8, "snapshot_14w21a"),
    SNAPSHOT_14W20B(18, v1_8, "snapshot_14w20b"),
    SNAPSHOT_14W20A(18, v1_8, "snapshot_14w20a"),
    SNAPSHOT_14W19A(17, v1_8, "snapshot_14w19a"),
    SNAPSHOT_14W18B(16, v1_8, "snapshot_14w18b"),
    SNAPSHOT_14W18A(16, v1_8, "snapshot_14w18a"),
    SNAPSHOT_14W17A(15, v1_8, "snapshot_14w17a"),
    SNAPSHOT_14W11A(14, v1_8, "snapshot_14w11a"),
    SNAPSHOT_14W10C(13, v1_8, "snapshot_14w10c"),
    SNAPSHOT_14W10B(13, v1_8, "snapshot_14w10b"),
    SNAPSHOT_14W10A(13, v1_8, "snapshot_14w10a"),
    SNAPSHOT_14W08A(12, v1_8, "snapshot_14w08a"),
    SNAPSHOT_14W07A(11, v1_8, "snapshot_14w07a"),
    SNAPSHOT_14W06B(10, v1_8, "snapshot_14w06b"),
    SNAPSHOT_14W06A(10, v1_8, "snapshot_14w06a"),
    SNAPSHOT_14W05B(9,  v1_8,   "snapshot_14w05b"),
    SNAPSHOT_14W05A(9,  v1_8,   "snapshot_14w05a"),
    SNAPSHOT_14W04B(8,  v1_8,   "snapshot_14w04b"),
    SNAPSHOT_14W04A(7,  v1_8,   "snapshot_14w04a"),
    SNAPSHOT_14W03B(6,  v1_8,   "snapshot_14w03b"),
    SNAPSHOT_14W03A(6,  v1_8,   "snapshot_14w03a"),
    SNAPSHOT_14W02C(5,  v1_8,   "snapshot_14w02c"),
    SNAPSHOT_14W02B(5,  v1_8,   "snapshot_14w02b"),
    SNAPSHOT_14W02A(5,  v1_8,   "snapshot_14w02a"),

    v1_7_10        (5,         "1.7.10"),
    v1_7_10_PRE4   (5, v1_7_10,"1.7.10-pre4"),
    v1_7_10_PRE3   (5, v1_7_10,"1.7.10-pre3"),
    v1_7_10_PRE2   (5, v1_7_10,"1.7.10-pre2"),
    v1_7_10_PRE1   (5, v1_7_10,"1.7.10-pre1"),
    v1_7_9         (5,         "1.7.9"),
    v1_7_8         (5,         "1.7.8"),
    v1_7_7         (5,         "1.7.7"),
    v1_7_6         (5,         "1.7.6"),
    v1_7_6_PRE2    (5, v1_7_6, "1.7.6-pre2"),
    v1_7_6_PRE1    (5, v1_7_6, "1.7.6-pre1"),
    v1_7_5         (4,         "1.7.5"),
    v1_7_4         (4,         "1.7.4"),
    v1_7_3         (4,         "1.7.3"),
    SNAPSHOT_13W49A(4, v1_7_3, "snapshot_13w49a"),
    SNAPSHOT_13W48B(4, v1_7_3, "snapshot_13w48b"),
    SNAPSHOT_13W48A(4, v1_7_3, "snapshot_13w48a"),
    SNAPSHOT_13W47E(4, v1_7_3, "snapshot_13w47e"),
    SNAPSHOT_13W47D(4, v1_7_3, "snapshot_13w47d"),
    SNAPSHOT_13W47C(4, v1_7_3, "snapshot_13w47c"),
    SNAPSHOT_13W47B(4, v1_7_3, "snapshot_13w47b"),
    SNAPSHOT_13W47A(4, v1_7_3, "snapshot_13w47a"),
    v1_7_2         (4,         "1.7.2"),
    v1_7_1         (3,         "1.7.1"),
    v1_7           (3,         "1.7"),
    SNAPSHOT_13W43A(2, v1_7,   "snapshot_13w43a"),
    SNAPSHOT_13W42B(1, v1_7,   "snapshot_13w42b"),
    SNAPSHOT_13W42A(1, v1_7,   "snapshot_13w42a"),
    SNAPSHOT_13W41B(0, v1_7,   "snapshot_13w41b"),
    SNAPSHOT_13W41A(0, v1_7,   "snapshot_13w41a"),

    UNKNOWN(-1, "unknown", VersionType.UNKNOWN),


    /* pre-netty rewrite */
    /* // nuke pre-netty rewrite
    SNAPSHOT_13W39B(80, v1_7, "13w39b"),
    SNAPSHOT_13W39A(80, v1_7, "13w39a"),
    SNAPSHOT_13W38C(79, v1_7, "13w38c"),
    SNAPSHOT_13W38B(79, v1_7, "13w38b"),
    SNAPSHOT_13W38A(79, v1_7, "13w38a"),
    v1_6_4(78, "1.6.4"),
    v1_6_3(77, "1.6.3"),
    SNAPSHOT_13W37B(76, v1_6_3, "13w37b"),
    SNAPSHOT_13W37A(76, v1_6_3, "13w37a"),
    SNAPSHOT_13W36B(75, v1_6_3, "13w36b"),
    SNAPSHOT_13W36A(75, v1_6_3, "13w36a"),
    v1_6_2(74, "1.6.2"),
    v1_6_1(73, "1.6.1"),
    v1_6(72, "1.6"),
    SNAPSHOT_13W26A(72, v1_6, "13w26a"),
    SNAPSHOT_13W25C(71, v1_6, "13w25c"),
    SNAPSHOT_13W25B(71, v1_6, "13w25b"),
    SNAPSHOT_13W25A(71, v1_6, "13w25a"),
    SNAPSHOT_13W24B(70, v1_6, "13w24b"),
    SNAPSHOT_13W24A(69, v1_6, "13w24a"),
    SNAPSHOT_13W23B(68, v1_6, "13w23b"),
    SNAPSHOT_13W23A(67, v1_6, "13w23a"),
    SNAPSHOT_13W22A(67, v1_6, "13w22a"),
    SNAPSHOT_13W21B(67, v1_6, "13w21b"),
    SNAPSHOT_13W21A(67, v1_6, "13w21a"),
    SNAPSHOT_13W19A(66, v1_6, "13w19a"),
    SNAPSHOT_13W18C(65, v1_6, "13w18c"),
    SNAPSHOT_13W18B(65, v1_6, "13w18b"),
    SNAPSHOT_13W18A(65, v1_6, "13w18a"),
    SNAPSHOT_13W17A(64, v1_6, "13w17a"),
    SNAPSHOT_13W16B(63, v1_6, "13w16b"),
    SNAPSHOT_13W16A(62, v1_6, "13w16a"),
    v1_5_2(61, "1.5.2"),
    v2_0_BLUE(90, -1, false, null, true, "2.0 Blue"), // april fools
    v2_0_RED(91, -1, false, null, true, "2.0 Red"), // april fools
    v2_0_PURPLE(92, -1, false, null, true, "2.0 Purple"), // april fools
    v1_5_1(60, "1.5.1"),
    SNAPSHOT_13W12(60, v1_5_1, "13w12~"),
    SNAPSHOT_13W11A(60, v1_5_1, "13w11a"),
    v1_5(60, "1.5"),
    SNAPSHOT_13W10B(60, v1_5, "13w10b"),
    SNAPSHOT_13W10A(60, v1_5, "13w10a"),
    SNAPSHOT_13W09C(60, v1_5, "13w09c"),
    SNAPSHOT_13W09B(59, v1_5, "13w09b"),
    SNAPSHOT_13W09A(59, v1_5, "13w09a"),
    SNAPSHOT_13W07A(58, v1_5, "13w07a"),
    SNAPSHOT_13W06A(58, v1_5, "13w06a"),
    SNAPSHOT_13W05B(57, v1_5, "13w05b"),
    SNAPSHOT_13W05A(56, v1_5, "13w05a"),
    SNAPSHOT_13W04A(55, v1_5, "13w04a"),
    SNAPSHOT_13W03A(54, v1_5, "13w03a"),
    SNAPSHOT_13W02B(53, v1_5, "13w02b"),
    SNAPSHOT_13W02A(53, v1_5, "13w02a"),
    SNAPSHOT_13W01B(52, v1_5, "13w01b"),
    SNAPSHOT_13W01A(52, v1_5, "13w01a"),
    v1_4_7(51, "1.4.7"),
    v1_4_6(51, "1.4.6"),
    SNAPSHOT_12W50B(51, v1_4_6, "12w50b"),
    SNAPSHOT_12W50A(51, v1_4_6, "12w50a"),
    SNAPSHOT_12W49A(50, v1_4_6, "12w49a"),
    v1_4_5(49, "1.4.5"),
    v1_4_4(49, "1.4.4"),
    v1_4_3(48, "1.4.3"),
    v1_4_2(47, "1.4.2"),
    v1_4_1(-1, "1.4.1"), // unknown
    v1_4(-1, "1.4"), // unknown
    SNAPSHOT_12W42B(46, v1_4, "12w42b"),
    SNAPSHOT_12W42A(46, v1_4, "12w42a"),
    SNAPSHOT_12W41B(46, v1_4, "12w41b"),
    SNAPSHOT_12W41A(46, v1_4, "12w41a"),
    SNAPSHOT_12W40B(45, v1_4, "12w40b"),
    SNAPSHOT_12W40A(44, v1_4, "12w40a"),
    SNAPSHOT_12W39B(43, v1_4, "12w39b"),
    SNAPSHOT_12W39A(43, v1_4, "12w39a"),
    SNAPSHOT_12W38B(43, v1_4, "12w38b"),
    SNAPSHOT_12W38A(43, v1_4, "12w38a"),
    SNAPSHOT_12W37A(42, v1_4, "12w37a"),
    SNAPSHOT_12W36A(42, v1_4, "12w36a"),
    SNAPSHOT_12W34B(42, v1_4, "12w34b"),
    SNAPSHOT_12W34A(41, v1_4, "12w34a"),
    SNAPSHOT_12W32A(40, v1_4, "12w32a"),
    v1_3_2(39, "1.3.2"),
    v1_3_1(39, "1.3.1"),
    v1_3(39, "1.3"),
    SNAPSHOT_12W30E(39, v1_3, "12w30e"),
    SNAPSHOT_12W30D(39, v1_3, "12w30d"),
    SNAPSHOT_12W30C(39, v1_3, "12w30c"),
    SNAPSHOT_12W30B(38, v1_3, "12w30b"),
    SNAPSHOT_12W30A(38, v1_3, "12w30a"),
    SNAPSHOT_12W27A(38, v1_3, "12w27a"),
    SNAPSHOT_12W26A(37, v1_3, "12w26a"),
    SNAPSHOT_12W25A(37, v1_3, "12w25a"),
    SNAPSHOT_12W24A(36, v1_3, "12w24a"),
    SNAPSHOT_12W23B(35, v1_3, "12w23b"),
    SNAPSHOT_12W23A(35, v1_3, "12w23a"),
    SNAPSHOT_12W22A(34, v1_3, "12w22a"),
    SNAPSHOT_12W21B(33, v1_3, "12w21b"),
    SNAPSHOT_12W21A(33, v1_3, "12w21a"),
    SNAPSHOT_12W19A(32, v1_3, "12w19a"),
    SNAPSHOT_12W18A(32, v1_3, "12w18a"),
    SNAPSHOT_12W17A(31, v1_3, "12w17a"),
    SNAPSHOT_12W16A(30, v1_3, "12w16a"),
    SNAPSHOT_12W15A(29, v1_3, "12w15a"),
    v1_2_5(29, "1.2.5"),
    v1_2_4(29, "1.2.4"),
    v1_2_3(28, "1.2.3"),
    v1_2_2(28, "1.2.2"),
    v1_2_1(28, "1.2.1"),
    v1_2(28, "1.2"),
    SNAPSHOT_12W08A(28, v1_2, "12w08a"),
    SNAPSHOT_12W07B(27, v1_2, "12w07b"),
    SNAPSHOT_12W07A(27, v1_2, "12w07a"),
    SNAPSHOT_12W06A(25, v1_2, "12w06a"),
    SNAPSHOT_12W05B(24, v1_2, "12w05b"),
    SNAPSHOT_12W05A(24, v1_2, "12w05a"),
    SNAPSHOT_12W04A(24, v1_2, "12w04a"),
    SNAPSHOT_12W03A(24, v1_2, "12w03a"),
    v1_1(23, "1.1"),
    SNAPSHOT_12W01A(23, "12w01a"),
    SNAPSHOT_11W50A(22, "11w50a"),
    SNAPSHOT_11W49A(22, "11w49a"),
    SNAPSHOT_11W48A(22, "11w48a"),
    SNAPSHOT_11W47A(22, "11w47a"),
    v1_0_1(22, "1.0.1"),
    v1_0_0(22, "1.0.0"),
    RC2(22, v1_0_0, "RC2"),
    RC1(22, v1_0_0, "RC1"),
    BETA_1_9_PRE6(22, v1_0_0, "Beta 1.9-pre6"),
    BETA_1_9_PRE5(21, v1_0_0, "Beta 1.9-pre5"),
    BETA_1_9_PRE4(20, v1_0_0, "Beta 1.9-pre4"),
    BETA_1_9_PRE3(19, v1_0_0, "Beta 1.9-pre3"),
    BETA_1_9_PRE2(19, v1_0_0, "Beta 1.9-pre2"),
    BETA_1_9_PRE(18, v1_0_0, "Beta 1.9-pre"),
    BETA_1_8_1(17, "Beta 1.8.1"),
    BETA_1_8(17, "Beta 1.8"),
    BETA_1_8_PRE2(16, BETA_1_8, "Beta 1.8-pre2"),
    BETA_1_8_PRE(15, BETA_1_8, "Beta 1.8-pre"),
    BETA_1_7_3(14, "Beta 1.7.3"),
    BETA_1_7_2(14, "Beta 1.7.2"),
    BETA_1_7_01(14, "Beta 1.7_01"),
    BETA_1_7(14, "Beta 1.7"),
    BETA_1_6_6(13, "Beta 1.6.6"),
    BETA_1_6_5(13, "Beta 1.6.5"),
    BETA_1_6_4(13, "Beta 1.6.4"),
    BETA_1_6_3(13, "Beta 1.6.3"),
    BETA_1_6_2(13, "Beta 1.6.2"),
    BETA_1_6_1(13, "Beta 1.6.1"),
    BETA_1_6(13, "Beta 1.6"),
    BETA_1_6_TEST_BUILD_3(12, "Beta 1.6 Test Build 3"),
    BETA_1_5_02(11, "Beta 1.5_02"),
    BETA_1_5_01(11, "Beta 1.5_01"),
    BETA_1_5(11, "Beta 1.5"),
    BETA_1_4_01(10, "Beta 1.4_01"),
    BETA_1_4(10, "Beta 1.4"),
    BETA_1_3_01(9, "Beta 1.3_01"),
    BETA_1_3(9, "Beta 1.3"),
    BETA_1_2_02(8, "Beta 1.2_02"),
    BETA_1_2_01(8, "Beta 1.2_01"),
    BETA_1_2(8, "Beta 1.2"),
    BETA_1_1_02(8, "Beta 1.1_02"),
    BETA_1_1_01(7, "Beta 1.1_01"),
    BETA_1_1(7, "Beta 1.1"),
    BETA_1_0_2(7, "Beta 1.0.2"),
    BETA_1_0_01(7, "Beta 1.0_01"),
    BETA_1_0(7, "Beta 1.0"),*/
    ;

    private final int protocolVersion;
    private final int dataVersion;
    private final String name;
    private final VersionType type;
    private final MCVersion mcVersion;

    MCVersion(int protocolVersion, int dataVersion, MCVersion mcVersion, String name, VersionType type) {
        this.protocolVersion = protocolVersion;
        this.dataVersion = dataVersion;
        this.mcVersion = mcVersion;
        this.name = name;
        this.type = type;
    }

    MCVersion(int protocolVersion, MCVersion mcVersion, String name) {
        this(protocolVersion, -1, mcVersion, name, getFromMCVersionName(name));
    }

    MCVersion(int protocolVersion, String name, VersionType type) {
        this(protocolVersion, -1, null, name, type);
    }

    MCVersion(int protocolVersion, String name) {
        this(protocolVersion, -1, null, name, getFromMCVersionName(name));
    }

    MCVersion(int protocolVersion, int dataVersion, MCVersion mcVersion, String name) {
        this(protocolVersion, dataVersion, mcVersion, name, getFromMCVersionName(name));
    }

    MCVersion(int protocolVersion, int dataVersion, String name) {
        this(protocolVersion, dataVersion, null, name, getFromMCVersionName(name));
    }

    MCVersion(int protocolVersion, int dataVersion, String name, VersionType type) {
        this(protocolVersion, dataVersion, null, name, type);
    }

    public String getName() {
        return name;
    }

    public int getDataVersion() {
        return dataVersion;
    }

    public int getProtocolVersion() {
        return protocolVersion;
    }

    public MCVersion getMcVersion() {
        return mcVersion;
    }

    public VersionType getType() {
        return type;
    }

    public boolean isSnapshot() {
        return type == VersionType.SNAPSHOT;
    }

    public boolean isExperimentalSnapshot() {
        return type == VersionType.EXPERIMENTAL_SNAPSHOT;
    }

    public boolean isAprilFools() {
        return type == VersionType.APRIL_FOOLS;
    }

    public boolean isReleaseCandidate() {
        return type == VersionType.RELEASE_CANDIDATE;
    }

    public boolean isRelease() {
        return type == VersionType.RELEASE;
    }

    public boolean isBeta() {
        return type == VersionType.BETA;
    }

    @Override
    public String toString() {
        return "MCVersion{" +
                "protocolVersion=" + protocolVersion +
                ", dataVersion=" + dataVersion +
                ", name='" + name + "'" +
                ", type=" + type +
                ", mcVersion=" + mcVersion +
                '}';
    }

    private static final Map<Integer, List<MCVersion>> cachedProtocolVersions = new HashMap<>();
    private static final Map<Integer, List<MCVersion>> cachedDataVersions = new HashMap<>();

    public static VersionType getFromMCVersionName(String name) {
        boolean releaseCandidate = name.toUpperCase().contains("RC");
        boolean prerelease = name.toUpperCase().contains("PRE");
        boolean snapshot = (name.toUpperCase().startsWith("SNAPSHOT_") || name.toUpperCase().contains("EXPERIMENTAL_SNAPSHOT"));
        boolean beta = name.toUpperCase().contains("BETA");
        if (releaseCandidate) return VersionType.RELEASE_CANDIDATE;
        else if (prerelease)  return VersionType.PRERELEASE;
        else if (snapshot)    return VersionType.SNAPSHOT;
        else if (beta)        return VersionType.BETA;
        else                  return VersionType.RELEASE;
    }

    public static List<MCVersion> getByProtocolVersions(int protocolVersion) {
        if (cachedProtocolVersions.get(protocolVersion) != null) return cachedProtocolVersions.get(protocolVersion);
        List<MCVersion> list = new ArrayList<>();
        for (MCVersion version : values()) {
            if (version.getProtocolVersion() == protocolVersion) list.add(version);
        }
        if (list.size() == 0) list.add(UNKNOWN);
        cachedProtocolVersions.put(protocolVersion, list);
        return list;
    }

    public static MCVersion getByProtocolVersion(int protocolVersion) {
        List<MCVersion> list = getByProtocolVersions(protocolVersion);
        if (list.get(0) == null) return UNKNOWN;
        return list.get(0);
    }


}
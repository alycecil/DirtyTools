import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.*;
import java.beans.XMLEncoder;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.logging.XMLFormatter;

public class splits {

    public static List<String> names = Arrays.asList("???",
            "Bulbasaur",
            "Ivysaur",
            "VenusaurM",
            "VenusaurF",
            "Charmander",
            "Charmeleon",
            "Charizard",
            "Squirtle",
            "Wartortle",
            "Blastoise",
            "Caterpie",
            "Metapod",
            "Butterfree",
            "Weedle",
            "Kakuna",
            "Beedrill",
            "Pidgey",
            "Pidgeotto",
            "Pidgeot",
            "Rattata",
            "Raticate",
            "Spearow",
            "Fearow",
            "Ekans",
            "Arboc",
            "PikachuM",
            "PikachuF",
            "Raichu",
            "Sandshrew",
            "Sandslash",
            "NidoranF",
            "Nidorina",
            "Nidoqueen",
            "NidoranM",
            "Nidorino",
            "Nidoking",
            "Clefairy",
            "Clefable",
            "Vulpix",
            "Ninetales",
            "Jigglypuff",
            "Wigglytuff",
            "Zubat",
            "Golbat",
            "Oddish",
            "Gloom",
            "Vileplume",
            "Paras",
            "Parasect",
            "Venonat",
            "Venomoth",
            "Diglett",
            "Dugtrio",
            "Meowth",
            "Persian",
            "Psyduck",
            "Golduck",
            "Mankey",
            "Primeape",
            "Growlithe",
            "Arcanine",
            "Poliwag",
            "Poliwhirl",
            "Poliwrath",
            "Abra",
            "Kadabra",
            "Alakazam",
            "Machop",
            "Machoke",
            "Machamp",
            "Bellsprout",
            "Weepinbell",
            "Victreebel",
            "Tentacool",
            "Tentacruel",
            "Geodude",
            "Graveler",
            "Golem",
            "Ponyta",
            "Rapidash",
            "Slowpoke",
            "Slowbro",
            "Magnemite",
            "Magneton",
            "Farfetch'd ",
            "Doduo",
            "Dodrio",
            "Seel",
            "Dewgong",
            "Grimer",
            "Muk",
            "Shellder",
            "Cloyster",
            "Gastly",
            "Haunter",
            "Gengar",
            "Onix",
            "Drowzee",
            "Hypno",
            "Krabby",
            "Kingler",
            "Voltorb",
            "Electrode",
            "Exeggcute",
            "Exeggutor",
            "Cubone",
            "Marowak",
            "Hitmonlee",
            "Hitmonchan",
            "Lickitung",
            "Koffing",
            "Weezing",
            "Rhyhorn",
            "Rhydon",
            "Chansey",
            "Tangela",
            "Kangaskhan",
            "Horsea",
            "Seadra",
            "Goldeen",
            "Seaking",
            "Staryu",
            "Starmie",
            "Mr. Mime",
            "Scyther",
            "Jynx",
            "Electabuzz",
            "Magmar",
            "Pinsir",
            "Tauros",
            "Magikarp",
            "Gyarados",
            "Lapras",
            "Ditto",
            "Eevee",
            "Vaporeon",
            "Jolteon",
            "Flareon",
            "Porygon",
            "Omanyte",
            "Omastar",
            "Kabuto",
            "Kabutops",
            "Aerodactyl",
            "Snorlax",
            "Articuno",
            "Zapdos",
            "Moltres",
            "Dratini",
            "Dragonair",
            "Dragonite",
            "Mewtwo",
            "Mew");

    public static void main(String... args) throws IOException {
        final BufferedImage source = ImageIO.read(new File("C:\\Users\\alyce\\IdeaProjects\\image\\src\\main\\resources\\DS DSi - Pokemon HeartGold SoulSilver - Kanto Pokemon.png"));
        BufferedWriter writer = new BufferedWriter(new FileWriter("pokemon.xml"));
        writer.write("<Defs>");
        int idx = 0;

        int yRow = 0;
        for (int y = 0; y < source.getHeight(); y += 128) {
            yRow++;
            if (yRow > 1) {
                y++;
            }
            int xRow = 0;
            for (int x = 0; x < source.getWidth(); x += 64) {
                xRow++;
                if (xRow == 2) {
                    x++;
                } else if (xRow == 3) {
                    x += 2;
                } else if (xRow == 4) {
                    x++;
                } else if (xRow >= 7) {
                    x++;
                }
                idx++;
                if (idx >= names.size()) break;

                String i = names.get(idx);

                String path = idx + "pokemon" + i;
                saveImage(source.getSubimage(x, y, 32, 32), "png", new File(path + "1_north.png"));
                saveImage(source.getSubimage(x, y + 32, 32, 32), "png", new File(idx + "pokemon" + i + "_north.png"));
                int w = xRow > 14 ? 29 : 30;
                saveImage(source.getSubimage(x + 32, y, w, 32), "png", new File(idx + "pokemon" + i + "1_west.png"));
                saveImage(source.getSubimage(x + 32, y + 32, w, 32), "png", new File(idx + "pokemon" + i + "_west.png"));
                saveImage(source.getSubimage(x, y + 32 + 32, 32, 32), "png", new File(idx + "pokemon" + i + "1_south.png"));
                saveImage(source.getSubimage(x, y + 32 + 32 + 32, 32, 31), "png", new File(idx + "pokemon" + i + "_south.png"));
                saveImage(source.getSubimage(x + 32, y + 32 + 32, w, 32), "png", new File(idx + "pokemon" + i + "1_east.png"));
                saveImage(source.getSubimage(x + 32, y + 32 + 32 + 32, w, 31), "png", new File(idx + "pokemon" + i + "_east.png"));



                writer.write(
                        defs(i, path));

            }
        }
writer.write("</Defs>");
        writer.close();

    }

    private static void saveImage(BufferedImage subimage, String png, File file) throws IOException {
        int alpha = subimage.getRGB(0, 0);

        final BufferedImage imageWithTransparency = makeColorTransparent(
                makeColorTransparent(subimage, new Color(alpha)),
                new Color(subimage.getRGB(subimage.getWidth()-1, subimage.getHeight()-1)));

        ImageIO.write(imageWithTransparency, png, file);
    }


    /**0
     * 0
     * Convert Image to BufferedImage.
     *
     * @param image Image to be converted to BufferedImage.
     * @return BufferedImage corresponding to provided Image.
     */
    private static BufferedImage imageToBufferedImage(final Image image)
    {
        final BufferedImage bufferedImage =
                new BufferedImage(32, 32, BufferedImage.TYPE_INT_ARGB);
        final Graphics2D g2 = bufferedImage.createGraphics();
        g2.drawImage(image, 0, 0, null);
        g2.dispose();
        return bufferedImage;
    }

    /**
     * Make provided image transparent wherever color matches the provided color.
     *
     * @param im BufferedImage whose color will be made transparent.
     * @param color Color in provided image which will be made transparent.
     * @return Image with transparency applied.
     */
    public static BufferedImage makeColorTransparent(final BufferedImage im, final Color color)
    {
        final ImageFilter filter = new RGBImageFilter()
        {
            // the color we are looking for (white)... Alpha bits are set to opaque
            int markerRGB = color.getRGB() | 0xFF000000;

            public final int filterRGB(final int x, final int y, final int rgb)
            {
                if ((rgb | 0xFF000000) == markerRGB)
                {
                    // Mark the alpha bits as zero - transparent
                    return 0x00FFFFFF & rgb;
                }
                else
                {
                    // nothing to do
                    return rgb;
                }
            }
        };

        final ImageProducer ip = new FilteredImageSource(im.getSource(), filter);
        return imageToBufferedImage(Toolkit.getDefaultToolkit().createImage(ip));
    }


    public static String defs(String pokemonName, String path) {
        //Pokemon def

        pokemonName = pokemonName.trim();
        String pokemonNameNoSpace = pokemonName.replaceAll(" ", "_").replaceAll("'", "_").replaceAll("\\.", "_");
        pokemonName = pokemonName.replaceAll("'", "&apos;");
        return "" +
                " <ThingDef ParentName=\"EggFertBase\">\n" +
                "    <defName>Egg" + pokemonNameNoSpace + "Fertilized</defName>\n" +
                "    <label>pokemonName egg (fert.)</label>\n" +
                "    <description>A fertilized " + pokemonName + " egg. If all goes well, it should hatch into a baby " + pokemonName + ". It can be eaten raw, but it's much better cooked.</description>\n" +
                "    <graphicData>\n" +
                "      <texPath>Things/Item/Resource/AnimalProductRaw/EggOval</texPath>\n" +
                "      <color>(215,215,235)</color>\n" +
                "    </graphicData>\n" +
                "    <statBases>\n" +
                "      <MarketValue>40.0</MarketValue>\n" +
                "    </statBases>\n" +
                "    <comps>\n" +
                "      <li Class=\"CompProperties_Hatcher\">\n" +
                "        <hatcherDaystoHatch>4.5</hatcherDaystoHatch>\n" +
                "        <hatcherPawn>" + pokemonNameNoSpace + "</hatcherPawn>\n" +
                "      </li>\n" +
                "\t\t</comps>\n" +
                "  </ThingDef>\n" +
                "<ThingDef ParentName=\"AnimalThingBase\">\n" +
                "    <defName>" + pokemonNameNoSpace + "</defName>\n" +
                "    <label>" + pokemonName + "</label>\n" +
                "    <description>Its a pokemon, buy a pokedex or whatever.</description>\n" +
                "    <statBases>\n" +
                "      <MoveSpeed>3.5</MoveSpeed>\n" +
                "      <MarketValue>150</MarketValue>\n" +
                "      <ComfyTemperatureMin>-20</ComfyTemperatureMin>\n" +
                "      <ComfyTemperatureMax>140</ComfyTemperatureMax>\n" +
                "    </statBases>\n" +
                "    <tools>\n" +
                "      <li>\n" +
                "        <label>generic attack</label>\n" +
                "        <power>12</power>\n" +
                "        <cooldownTime>2</cooldownTime>\n" +
                "        <linkedBodyPartsGroup>Mouth</linkedBodyPartsGroup>\n" +
                "        <surpriseAttack>\n" +
                "          <extraMeleeDamages>\n" +
                "            <li>\n" +
                "              <def>Stun</def>\n" +
                "              <amount>14</amount>\n" +
                "            </li>\n" +
                "          </extraMeleeDamages>\n" +
                "        </surpriseAttack>\n" +
                "      </li>\n" +
                "      <li>\n" +
                "        <label>head</label>\n" +
                "        <capacities>\n" +
                "          <li>Blunt</li>\n" +
                "        </capacities>\n" +
                "        <power>3</power>\n" +
                "        <cooldownTime>2</cooldownTime>\n" +
                "        <linkedBodyPartsGroup>HeadAttackTool</linkedBodyPartsGroup>\n" +
                "        <ensureLinkedBodyPartsGroupAlwaysUsable>true</ensureLinkedBodyPartsGroupAlwaysUsable>\n" +
                "        <chanceFactor>0.2</chanceFactor>\n" +
                "      </li>\n" +
                "      <li>\n" +
                "        <label>special attack</label>\n" +
                "        <power>3</power>\n" +
                "        <cooldownTime>2</cooldownTime>\n" +
                "        <chanceFactor>0.2</chanceFactor>\n" +
                "      </li>\n" +
                "    </tools>\n" +
                "    <comps>\n" +
                "      <li Class=\"CompProperties_EggLayer\">\n" +
                "        <eggFertilizedDef>Egg" + pokemonNameNoSpace + "Fertilized</eggFertilizedDef>\n" +
                "        <eggFertilizationCountMax>1</eggFertilizationCountMax>\n" +
                "        <eggLayIntervalDays>20.0</eggLayIntervalDays>\n" +
                "        <eggProgressUnfertilizedMax>0.5</eggProgressUnfertilizedMax>\n" +
                "        <eggCountRange>\n" +
                "          <min>1</min>\n" +
                "          <max>2</max>\n" +
                "        </eggCountRange>\n" +
                "      </li>" +
                "      <li Class=\"CompAnimated.CompProperties_Animated\">\n" +
                "       <movingFrames>\n" +
                "\t\t  <li>\n" +
                "            <texPath>"+path+"</texPath>\n" +
             //   "            <color>(110,95,82)</color>\n" +
                "            <drawSize>1.5</drawSize>\n" +
                "            <shaderType>CutoutComplex</shaderType>\n" +
                "\t\t    <graphicClass>Graphic_Multi</graphicClass>\n" +
                "\t\t  </li>\n" +
                "\t\t  <li>\n" +
                "            <texPath>"+path+"1</texPath>\n" +
             //   "            <color>(110,95,82)</color>\n" +
                "            <drawSize>1.5</drawSize>\n" +
                "            <shaderType>CutoutComplex</shaderType>\n" +
                "\t\t    <graphicClass>Graphic_Multi</graphicClass>\n" +
                "\t\t  </li>\n" +
                "\t\t</movingFrames>\n" +
                "\t\t<sound/>\n" +
                "\t\t<secondsBetweenFrames>0.15</secondsBetweenFrames>\n" +
                "\t  </li>\n" +
                "    </comps>\n" +
                "    <race>\n" +
                "      <body>Snake</body>\n" +
                "      <predator>true</predator>\n" +
                "      <maxPreyBodySize>0.35</maxPreyBodySize>\n" +
                "      <baseBodySize>0.25</baseBodySize>\n" +
                "      <baseHungerRate>0.07</baseHungerRate>\n" +
                "      <baseHealthScale>0.5</baseHealthScale>\n" +
                "      <foodType>CarnivoreAnimal, OvivoreAnimal</foodType>\n" +
                "      <leatherDef>Leather_Lizard</leatherDef>\n" +
                "      <meatLabel>cobraflesh</meatLabel>\n" +
                "      <wildness>0.75</wildness>\n" +
                "      <petness>0.05</petness>\n" +
                "      <manhunterOnTameFailChance>0.01</manhunterOnTameFailChance>\n" +
                "      <manhunterOnDamageChance>0.01</manhunterOnDamageChance>\n" +
                "      <nameOnTameChance>1</nameOnTameChance>\n" +
                "      <lifeExpectancy>20</lifeExpectancy>\n" +
                "      <lifeStageAges>\n" +
                "        <li>\n" +
                "          <def>AnimalBaby</def>\n" +
                "          <minAge>0</minAge>\n" +
                "        </li>\n" +
                "        <li>\n" +
                "          <def>AnimalJuvenile</def>\n" +
                "          <minAge>0.15</minAge>\n" +
                "        </li>\n" +
                "        <li>\n" +
                "          <def>AnimalAdult</def>\n" +
                "          <minAge>0.5</minAge>\n" +
                "          <soundWounded>Pawn_Cobra_Wounded</soundWounded>\n" +
                "          <soundDeath>Pawn_Cobra_Death</soundDeath>\n" +
                "          <soundCall>Pawn_Cobra_Call</soundCall>\n" +
                "          <soundAngry>Pawn_Cobra_Angry</soundAngry>\n" +
                "        </li>\n" +
                "      </lifeStageAges>\n" +
                "      <soundMeleeHitPawn>Pawn_Melee_SmallScratch_HitPawn</soundMeleeHitPawn>\n" +
                "      <soundMeleeHitBuilding>Pawn_Melee_SmallScratch_HitBuilding</soundMeleeHitBuilding>\n" +
                "      <soundMeleeMiss>Pawn_Melee_SmallScratch_Miss</soundMeleeMiss>\n" +
                "    </race>\n" +
                "    <tradeTags>\n" +
                "      <li>AnimalUncommon</li>\n" +
                "      <li>AnimalFighter</li>\n" +
                "    </tradeTags>\n" +
                "  </ThingDef>" +
                "   <PawnKindDef ParentName=\"AnimalKindBase\">\n" +
                "    <defName>" + pokemonNameNoSpace + "</defName>\n" +
                "    <label>" + pokemonName + "</label>\n" +
                "    <race>" + pokemonNameNoSpace + "</race>\n" +
                "    <combatPower>65</combatPower>\n" +
                "    <ecoSystemWeight>0.25</ecoSystemWeight>\n" +
                "    <lifeStages>\n" +
                "      <li>\n" +
                "        <bodyGraphicData>\n" +
                "          <texPath>" + path + "</texPath>\n" +
                "          <drawSize>1</drawSize>\n" +
                "        </bodyGraphicData>\n" +
                "        <dessicatedBodyGraphicData>\n" +
                "          <texPath>" + path + "</texPath>\n" +
                "          <drawSize>1</drawSize>\n" +
                "        </dessicatedBodyGraphicData>\n" +
                "      </li>\n" +
                "      <li>\n" +
                "        <bodyGraphicData>\n" +
                "          <texPath>" + path + "</texPath>\n" +
                "          <drawSize>1.25</drawSize>\n" +
                "        </bodyGraphicData>\n" +
                "        <dessicatedBodyGraphicData>\n" +
                "          <texPath>" + path + "</texPath>\n" +
                "          <drawSize>1.25</drawSize>\n" +
                "        </dessicatedBodyGraphicData>\n" +
                "      </li>\n" +
                "      <li>\n" +
                "        <bodyGraphicData>\n" +
                "          <texPath>" + path + "</texPath>\n" +
                "          <drawSize>1.5</drawSize>\n" +
                "        </bodyGraphicData>\n" +
                "        <dessicatedBodyGraphicData>\n" +
                "          <texPath>" + path + "</texPath>\n" +
                "            <color>(110,95,82)</color>\n" +
                "          <drawSize>1.5</drawSize>\n" +
                "        </dessicatedBodyGraphicData>\n" +
                "      </li>\n" +
                "    </lifeStages>\n" +
                "  </PawnKindDef>" +
                "";
    }
}




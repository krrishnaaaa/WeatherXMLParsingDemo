# WeatherXMLParsingDemo
Demo app to demonstrate parsing nested XML using SAX Parser

In this tutorial we are using API from https://www.worldweatheronline.com/  

This tutorial is currently limited to parsing few nested data from XML response and displaying on the screen. The API provides so many details, but we are parsing only following things.

```
<data>
    <current_condition>
        <observation_time>05:41 AM</observation_time>
        <temp_C>33</temp_C>
        <temp_F>92</temp_F>
        <weatherIconUrl>
            <![CDATA[ http://cdn.worldweatheronline.com/images/wsymbols01_png_64/wsymbol_0009_light_rain_showers.png ]]>
        </weatherIconUrl>
        <weatherDesc>
            <![CDATA[ Patchy rain possible ]]>
        </weatherDesc>
        <FeelsLikeC>34</FeelsLikeC>
        <FeelsLikeF>93</FeelsLikeF>
        <uvIndex>7</uvIndex>
    </current_condition>
    <weather>
        <date>2021-06-02</date>
        <maxtempC>41</maxtempC>
        <maxtempF>107</maxtempF>
        <mintempC>29</mintempC>
        <mintempF>83</mintempF>
        <avgtempC>35</avgtempC>
        <avgtempF>94</avgtempF>
    </weather>
    <weather>
        <date>2021-06-03</date>
        <maxtempC>43</maxtempC>
        <maxtempF>109</maxtempF>
        <mintempC>33</mintempC>
        <mintempF>91</mintempF>
        <avgtempC>38</avgtempC>
        <avgtempF>100</avgtempF>
    </weather>
    <weather>
        <date>2021-06-04</date>
        <maxtempC>43</maxtempC>
        <maxtempF>109</maxtempF>
        <mintempC>33</mintempC>
        <mintempF>91</mintempF>
        <avgtempC>38</avgtempC>
        <avgtempF>100</avgtempF>
    </weather>
    <weather>
        <date>2021-06-05</date>
        <maxtempC>41</maxtempC>
        <maxtempF>106</maxtempF>
        <mintempC>33</mintempC>
        <mintempF>91</mintempF>
        <avgtempC>37</avgtempC>
        <avgtempF>99</avgtempF>
    </weather>
    <weather>
        <date>2021-06-06</date>
        <maxtempC>42</maxtempC>
        <maxtempF>108</maxtempF>
        <mintempC>35</mintempC>
        <mintempF>94</mintempF>
        <avgtempC>39</avgtempC>
        <avgtempF>102</avgtempF>
    </weather>
</data>
```

We hope you don't have to parse anything mannually :P. But, if it gets down to manual XML parsing, then we hope the provided implementation of SAXParser solves you purpose.  


In case you encounter any issue, please raise a bug or you can ping us on Slack https://pcsalt.slack.com/

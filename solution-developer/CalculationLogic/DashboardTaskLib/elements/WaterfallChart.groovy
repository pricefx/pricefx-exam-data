import net.pricefx.server.dto.calculation.ResultHighchart

/**
 * Builds and returns a definition of the Waterfall chart.
 * @param cost Positive value of the cost. It will be used for the first pricepoint and also for Cost adjustment.
 * @param markup Positive value used for Markup adjustment.
 * @param discount Positive value used for Discount adjustment.
 * @return ResultHighchart object, which can be directly used as a result of logic element.
 */
ResultHighchart buildWaterfallChart(BigDecimal cost, BigDecimal markup, BigDecimal discount) {

    def data = [  //data sequence should follow that of the waterfall elements
                  [
                          name : 'Cost',
                          y    : cost,
                          color: '#4573a7'
                  ],
                  [
                          name: 'Markup',
                          y   : markup
                  ],
                  [
                          name : 'ListPrice',
                          isSum: true, //this will add up previous Y-axis values since the last intermediate sum, or since the start of the series. y value will be ignored
                          color: '#4573a7' //blue - explicitly specify the color, otherwise series.color will be used
                  ],
                  [
                          name: 'Discount',
                          y   : -discount
                  ],
                  [
                          name             : 'InvoicePrice',
                          isIntermediateSum: true, //this will add up previous Y-axis values since the last intermediate sum, or since the start of the series. y value will be ignored
                          color            : '#4573a7' //blue - explicitly specify the color, otherwise series.color will be used
                  ],
                  [
                          name: 'ProductionCost',
                          y   : -cost
                  ],
                  [
                          name : 'Margin',
                          isSum: true, //this will add up all previous yAxis values since the start of the series. y value will be ignored
                          color: '#4573a7'
                  ]
    ]

    def definition = [
            chart   : [
                    type: 'waterfall'
            ],

            title   : [
                    text: 'Title'
            ],

            subtitle: [
                    text: 'Subtitle'
            ],

            xAxis   : [
                    type: 'category' //when type is 'category', series.data.name will become X-axis value
            ],

            yAxis   : [
                    title: [
                            enabled: false
                    ]
            ],

            legend  : [
                    enabled: false
            ],

            tooltip : [
                    pointFormat: '<b>{point.y:,.2f}</b> USD'
            ],

            series  : [
                    [
                            upColor     : '#89a54e', //green - this is color of the positive elements
                            color       : '#aa4643', //red - this is color of all elements, unless explicitly specified
                            data        : data,
                            dataLabels  : [
                                    enabled: true,
                                    format : '{point.y:,.2f} USD',
                                    style  : [
                                            fontWeight: 'bold'
                                    ]
                            ],
                            pointPadding: 0
                    ]
            ],
            credits : [
                    enabled: false
            ]
    ]

    return api.buildHighchart(definition)
}